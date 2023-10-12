console.log('todo.js open');

let url = 'http://localhost:8080/todo';

// 1. POST
function onWrite() {

    let tcontent = document.querySelector('.tcontent').value;
    let tstate = false;
    console.log(tcontent);

    $.ajax({
    url : url,
    method : "post",
    data : {tcontent : tcontent
            ,tstate : tstate
            } ,
    success : r => {
        alert('등록 되었습니다.');
        getContent();
    } ,
    error : e =>{}
    })

}
getContent();
// 2. GET
function getContent(){

    console.log('getContent 실행');

   let todo = document.querySelector('.todo');
   let html = ``;

    $.ajax({
    url : url,
    method : "GET",
    data : "",
    success : r => {
        console.log(r);
        r.forEach(e => {

            html += `<div class = ${e.tstate == true ? "successTodo" : ""} >
                        ${e.tcontent}
                     </div>
                    <div class="etcbtns">
                        <button onclick="onPut(${e.tstate})" type="button">상태변경</button>
                        <button onclick="onDelete(${e.tno})" type="button">제거하기</button>
                    </div>
                     `;

        })
        todo.innerHTML = html;
    },
    error : e =>{ console.log(e);}
    });// ajax end
    } // getContent end

// 3. PUT
function onPut(tstate) {

    $.ajax({
    url : url,
    method : "put",
    data : {tstate : tstate},
    success : r => {
        alert("수정 되었습니다.")
        getContent();
    } ,
    error : e =>{}
    })

}

// 4. DELETE

function onDelete(tno) {

    $.ajax({
        url : url,
        method : "delete",
        data : {tno:tno},
        success : r => {
            alert("삭제 되었습니다.")
            getContent();
        } ,
        error : e =>{}
        })

}