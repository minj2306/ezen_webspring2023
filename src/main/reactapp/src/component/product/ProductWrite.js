export default function ProductWrite( props ){



    return(<>
        <h3>제품등록</h3>
        <select>{
            props.categoryList.map( (c) => {
                return(<>
                     <option value={c.pcno}>{c.pcname}</option>;
                    </>)
            })
            }
        </select>
    </>)
}