/*
    컴포넌트 만들기
        - 파일명 : 아무거나.js 혹은 아무거나.jsx [ 권장 : 컴포넌트명과 동일 ]
        - 컴포넌트 원형
            - 컴포넌트명 : 첫글자는 대문자 [ 무조건 , 카멜 표기법 ]
            export default function 컴포넌트명( props ){
                return(<></>)
            }
    컴포넌트 랜더링
        - 최상위 랜더링( 가장 먼저 랜더링 )
            1. index.js
                import 컴포넌트명 from '컴포넌트경로'
                root.render( <React.StrictMode>  <컴포넌트명 /> </React.StrictMode> );

        - 라우터 : 가상 URL 만들기
            - 실제 라우터 : 연결 경로를 자동으로 전환해주는 기계
            - 리액트 라우터 : 가상 경로[ HTTP URL]를 만들어서 컴포넌트를 전환 해주는 라이브러리
            - 설치
                1. https://www.npmjs.com/
                2. router-dom 검색
                3. 리액트 버전 주의!!!!!!
                   npm i router-dom    [ 2.2.11  ]
                   npm i react-router-dom [ 6.17.0 ] 수업 버전!!!
               4. 터미널(alt+f12)
                    1. 터미널 종료
                    2. 리액트 프로젝트 이동 [ cd src/main/reactapp ]

            - 해당 파일에서 외부라이브러리 import
                import { BrowserRouter , Routes , Route , Link } from "react-router-dom"

                <BrowserRouter>
                    <Routes >
                        <Route path='컴포넌트URL정의' element = { <컴포넌트명 /> } />
                    </Routes >
                </BrowserRouter>

            - 다른 컴포넌트에서 컴포넌트(페이지) 전환
                라우터경로 : Route컴포넌트의 path속성에서 정의된URL
                1. <a href='(서버/라우터)경로'> </a>            페이지 리로드 O
                2. <Link to='라우터경로'> </Link>              페이지 리로드 X
*/

import { BrowserRouter , Routes , Route , Link } from "react-router-dom"
import 컴포넌트1 from '../day01/1_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트2 from '../day01/2_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트명 from '../day01/3_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출
import 컴포넌트4 from '../day01/4_컴포넌트' // 다른 폴더에 있는 컴포넌트 호출



export default function 라우터컴포넌트( props ){
                return(<>

                    <BrowserRouter>{/*브라우저 라우터 시작*/}
                        <고정컴포넌트/>{/*BrowserRouter 안에 있고 Routes 밖에 있는 컴포넌트 */}
                        <Routes>/*화면이 전환되는 컴포넌트들의 URL 정의 공간*/
                            <Route path ='/day01/컴포넌트1' element = { <컴포넌트1/> } /> {/* 컴포넌트롤 연결할 가상 URL 경로 정의 */}
                            <Route path ='/day01/컴포넌트2' element = { <컴포넌트2/> } /> {/* 컴포넌트롤 연결할 가상 URL 경로 정의 */}
                            <Route path ='/day01/컴포넌트3' element = { <컴포넌트명/> } /> {/* 컴포넌트롤 연결할 가상 URL 경로 정의 */}
                            <Route path ='/day01/컴포넌트4' element = { <컴포넌트4/> } /> {/* 컴포넌트롤 연결할 가상 URL 경로 정의 */}
                        </Routes>
                    </BrowserRouter>{/*브라우저 라우터 끝*/}
                </>)
}

function 고정컴포넌트( props ){
    return(<>
        <div>{/* a태그는 페이지 리로드 */}
            <a href='/day01/컴포넌트1'>컴포넌트1</a>
            <a href='/day01/컴포넌트2'>컴포넌트2</a>
            <a href='/day01/컴포넌트3'>컴포넌트명</a>
            <a href='/day01/컴포넌트4'>컴포넌트4</a>
        </div>
        <div>{/* Link 컴포넌트는 페이지 리로드 x */}
            <Link to='/day01/컴포넌트1'>컴포넌트1</Link>
            <Link to='/day01/컴포넌트2'>컴포넌트2</Link>
            <Link to='/day01/컴포넌트3'>컴포넌트명</Link>
            <Link to='/day01/컴포넌트4'>컴포넌트4</Link>
        </div>
    </>)
}