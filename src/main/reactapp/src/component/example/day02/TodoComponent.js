
import style from './TodoComponent.css';

export default function TodoContent(props) {

    return (<>
        <div className = "todo">
           <div className = "tcontent" >
               {props.content}
            </div>
           <div className="etcbtns">
               <button type="button">상태변경</button>
               <button type="button">제거하기</button>
           </div>
        </div>
    </>)
}