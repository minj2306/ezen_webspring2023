// 리액트 확장자 : jsx , js

// 1. 컴포넌트 문법 원형
/*function 컴포넌트명( props ){
    return(<>

    </>)
}*/

//export default 컴포넌트명

// 1-1 css 속성 [ 카멜표기법 background-color --> backgroundColor ] 이 정의된 객체 선언
// 1-2 마크업 style 속성

// 3.
        // import style from 'css파일 경로';
import style from './컴포넌트.css';
// 2. 컴포넌트 문법 원형
export default function CSS컴포넌트( props ){

    // 1. CSS 를 객체의 속성[카멜표기법] 으로 선언하기
    const ccsStyle = {
        backgroundColor: 'red',
        width:'500px' ,
        height : '100px' ,
        margin : '0 auto',
    }

    return(<>
        <div style = {ccsStyle}> CSS 적용하는 방법1 </div>
        { /* style 속성에 {{ 속성명 : 값 , 속성명 : 값 }} */ }
        <div style = { {
                       backgroundColor: 'blue',
                       width:'500px' ,
                       height : '100px' ,
                       margin : '0 auto',
                           } } > CSS 적용하는 방법2 </div>
        <div className="box3" > CSS 적용하는 방법3 </div>
    </>)
}


