
function 과제1 (){
    return(<>
        <과제태그 도서명 ="이것이 자바다" 저자="유재석" 소비자가격={30000}/>
        <과제태그 도서명 ="이것이 파이썬" 저자="강호동" 소비자가격={25000}/>
        <과제태그 도서명 ="이것이 리액트" 저자="신동엽" 소비자가격={28000}/>
        </>)
}

function 과제태그( props ){
    return (<>
        <h3>도서명 : {props.도서명}</h3>
        <div>
            저자 : {props.저자} / 소비자가격 {props.가격}
        </div>
    </>)
}

export default 과제1