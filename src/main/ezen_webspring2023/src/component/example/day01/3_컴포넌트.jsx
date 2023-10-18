/*
    컴포넌트 내부에서 다른 컴포넌트 호출하는 방법
        1. 같은 jsx 파일이면 import 생략
        2. 다른 jsx 파일이면 import

 */

function 컴포넌트명 (){
    return(<>
        <h3>'컴포넌트3'컴포넌트(함수)에서 작성된 HTML</h3>
        {/* 다른 컴포넌트(함수) 호출하는 방법 */}
        <내가만든태그/>{/* JSX형식의 주석처리 */}
       <input/>
    </>)
}

function 내가만든태그(){
    return(<>
        <div>'내가만든태그'컴포넌트(함수)에서 작성된 HTML </div>
    </>)
}

export default 컴포넌트명;

