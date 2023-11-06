import { BrowserRouter, Routes, Route , Link  } from'react-router-dom'
// 4. HTTP URL 경로상의 쿼리스트링 매개변수 호출 라이브러리 호출
import { useSearchParams } from 'react-router-dom'
import{ useParams } from 'react-router-dom'// 4. HTTP url 경로상의 경로매개변수 호출 라이브러리 호출
import { useState } from'react'

// 1. 상위 컴포넌트 라우터
export default function 라우터매개변수( props ) {
    return(<>
        <h3> 라우터 매개변수 </h3>
        <BrowserRouter>
            <Routes>
            <Route path="/" element={ < 목록페이지/>} />
            {/*매개변수인지 경로인지 구분 가능?*/}
            <Route path="/view1" element={ < 상세페이지_쿼리스트링/>} />

            {/*매개변수인지 경로인지 구분 :매개변수*/}
            <Route path="/view2/:bno" element={ < 상세페이지_경로/>} />

            </Routes>
        </BrowserRouter>
    </>)
}

// 2. 메인 컴포넌트
function 목록페이지( props ) {
    const [ value , setValue] = useState( '' );
    return(<>
        <h3>목록페이지</h3>
        <input type="text" onChange={ (e) => { setValue(e.target.value) } } /> <br/>
        <Link to={"/view1?bno=1&value="+value}>상세페이지_쿼리스트링</Link><br/>
        <Link to={"/view2/"+value}>상세페이지_경로</Link>
    </>)
}

// 3. 하위 컴포넌트
function 상세페이지_쿼리스트링( props ) {
    const [ searchParams , setSearchParams ] = useSearchParams()
    console.log( searchParams );

    let bno = searchParams.get('bno');
    let value = searchParams.get('value');

    return(<>
        <h3>상세페이지_쿼리스트링 bno = {bno} value ={value}</h3>
    </>)
}

// 4. 하위 컴포넌트
function 상세페이지_경로( props ) {
    const params = useParams();
    console.log( params );

    let bno = params.bno;
    let value = params.value;
    return(<>
        <h3>상세페이지_경로
            bno = {bno}
            value= {value}</h3>
    </>)
}