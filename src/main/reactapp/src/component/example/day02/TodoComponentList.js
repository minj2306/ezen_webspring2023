import TodoContent from './TodoComponent.js';

export default function TodoList(props) {

        let response = [
            {content: '리액트 배우기'} ,
            {content: '자바 배우기'} ,
            {content: '파이썬 배우기'} ,
            {content: 'C언어 배우기'}
        ];

      return(<>
        <div className="todowrap">
            <h1> 나만의 할 일 목록</h1>
            <div className="todo_top">
                <input className="tcontent" type="text"/>
                <button type="button"> 등록</button>
            </div>
            <div className="todo_bottom">

                    {
                    response.map( (r)=>{
                        return(
                            <TodoContent content={r.content} />
                        )
                    })
                    }

            </div>
        </div>
      </>)

}