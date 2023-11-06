import { useSearchParams } from'react-router-dom'
import { Link } from'react-router-dom';
import axios from 'axios';
import { useState , useEffect } from'react';
export default function BoardView( props ) {

    // 1. HTTP 경로상의 쿼리스트링 매개변수 호출
    const [ searchParams , setSearchParams ] = useSearchParams();
    const bno = searchParams.get('bno');

    // 2. 현재 게시물의 정보를 가니는 상태관리 변수
    const [ board , setBoard ] = useState({});

    // 3. 현재 로그인된 회원의 번호
    const login = JSON.parse(sessionStorage.getItem('login_token'));

    const loginMno = login != null ? login.mno : null ;
    console.log(loginMno);
    // 3. 개별 게시물 axios
    const onGet = (e) => {
        axios.get("/board/doGet", { params : { bno : bno } } )
        .then( r => {
            setBoard(r.data);
            console.log(r);
        })
    }
    useEffect( () => { onGet() } ,[] )
    // 1. 삭제 axios
    const onDelete = (e) => {
        axios.delete("/board" , { params : { bno : bno } } )
        .then( r => {
            if( r.data ) {alert('게시물 삭제 성공'); window.location.href ="/board/list"}
            else{alert('게시물 삭제 실패'); }
        })
    }

    return(<>
        <div>
            <h3>개별게시물 {bno}</h3>
            <div>{board.btitle}</div>
            <div>{board.bcontent}</div>

            {/*삭제와 수정은 본인만 가능*/}
            {/*삼항연산자 조건 ? (<>참일때</>) : (<>거짓일때</>) */}
            {
                board.mno == loginMno ?
                    (<>
                        <button type="button" onClick={onDelete}>
                            삭제
                        </button>
                        <Link to={"/board/update?bno="+bno}>
                            <button type="button">
                                수정
                            </button>
                        </Link>
                    </>) :
                    (<></>)
            }
        </div>
    </>)
}