import axios from 'axios';
import { useState , useEffect } from 'react';


export default function ProductList( props ){

    let [ productList , setProductList ] = useState([]);

    const onProductAll = (e) => {
        axios.get("/product")
        .then( (r) =>{
            console.log(r.data);
            setProductList( r.data );
        })

    }

    useEffect( () => { onProductAll() } , [] )

    return(<>
        <h3>제품 목록</h3>
        <table style={{ width : '100%' }}>
            <tr>
                <th style={{width : '10%'}}>제품번호</th>
                <th style={{width : '10%'}} >대표이미지</th>
                <th style={{width : '10%'}} >카테고리명</th>
                <th style={{width : '10%'}} >제품명</th>
                <th style={{width : '10%'}} >제품가격</th>
                <th style={{width : '10%'}} >상태</th>
                <th style={{width : '10%'}} >재고</th>
                <th style={{width : '10%'}} >비고</th>
            </tr>
            {
                productList.map( (p) => {
                    return(<>
                         <tr>
                             <td>{p.pno}</td>
                             <td>
                                <img  style={{ width : '100%'}} src={"http://localhost:8080/static/media/"+p.imgList[0].uuidFileName } />
                             </td>
                             <td>{p.categoryDto.pcname}</td>
                             <td>{p.pname}</td>
                             <td>{p.pprice}</td>
                             <td>{p.pstate}</td>
                             <td>{p.pstock}</td>
                             <td>비고</td>
                         </tr>
                    </>)
                })
            }
        </table>
    </>)
}