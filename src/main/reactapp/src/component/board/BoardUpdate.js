import { useSearchParams } from'react-router-dom'
import { Link } from'react-router-dom';
import axios from 'axios';
import { useState , useEffect } from'react';

export default function BoardUpdate( props ) {

    const [ searchParams, setSearchParams ] = useSearchParams();
    const bno = searchParams.get('bno');

    const [ board , setBoard ] = useState({});
    const onGet = (e) => {
            axios.get("/board/doGet", { params : { bno : bno } } )
            .then( r => {
                setBoard(r.data);
                console.log(r);
            })
        }
    useEffect( () => { onGet() } ,[] )

    // 3. 개별 게시물 수정 요청
    const boardUpdate = (e) => {
        const boardForm = document.querySelectorAll('.boardForm')[0];
        const boardFormData = new FormData(boardForm);
        // boardFormData : 입력받은 수정할제목 , 내용 +++
        boardFormData.set('bno', bno);
        axios.put("/board", boardFormData)
        .then( r => {
            if(r.data){alert('글 수정 성공'); window.location.href="/board/view?bno="+bno}
            else{alert('글 수정 실패'); }
        })
    }

    return(<>
        <div> 글 수정 페이지 </div>
         <form className="boardForm">
            <input type="text"
            placeholder="제목"
            name="btitle"
            value={board.btitle}
            onChange={ (e) => setBoard({...board , btitle : e.target.value})}
            /><br />
            <textarea
            placeholder="내용"
            name="bcontent"
            value={board.bcontent}
            onChange={ (e) => setBoard({...board , bcontent : e.target.value})}
            ></textarea><br />
            <button type="button" onClick={boardUpdate}> 수정 </button>
        </form>
    </>)
}
