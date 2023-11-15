import axios from 'axios';
//[ 소켓 1 ]
import { useContext } from 'react';
import { SocketContext } from '../Index.js';

export default function ProductWrite( props ){


    // [ 소켓 2 ] 상위 컴포넌트에 있는 context 의 들어있는 클라이언소켓 꺼내기
    const clientSocket = useContext( SocketContext ).current;



    // 1. 제품등록
    const onProductAdd = (e) => {
        let productForm = document.querySelectorAll('.productForm')[0];

        console.log(productForm)
        let productFormData = new FormData( productForm );
        console.log(productFormData)
        axios.post("/product" , productFormData )
        .then( r => {
            if(r.data){
                // [ 소켓 3 ] : 서버에게 메세지 보내기
                clientSocket.send("새로운 제품이 등록되었습니다.")
                productForm.reset();
            }
            else{ alert( "제품등록 실패" ) }
        })
    }


    return(<>
        <div style={{ width : '300px' , margin : '0 auto'}}>
            <h3>제품등록</h3>
            <form className="productForm">
                <select name="pcno">{
                    props.categoryList.map( (c) => {
                        return(<>
                             <option value={c.pcno}>{c.pcname}</option>;
                            </>)
                    })
                    }
                </select>
                <input type="text" name="pname" placeholder=""/><br/>
                <textarea name="pcomment" placeholder="제품설명"></textarea><br/>
                <input type="text" name="pprice" placeholder="제품가격"/><br/>
                <input type="text" name="pstock" placeholder="초기재고"/><br/>
                <input type="file" name="fileList" multiple /><br/>
                <button type="button" onClick={ onProductAdd }>등록</button>
            </form>
        </div>
    </>)
}