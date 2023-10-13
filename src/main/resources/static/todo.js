console.log('todo.js open');



// 1. POST
function onWrite() {


    let tcontent = document.querySelector('.tcontent').value;
    let tstate = false;
    console.log(tcontent);

    let writeObject = { tcontent : tcontent
                        ,tstate : tstate
                       }

    $.ajax({
    url : "http://localhost:8080/todo",
    method : "post",
    dataType : "json",
    contentType : "application/json",
    data : JSON.stringify(writeObject),
    success : r => {
        console.log(r);
        if(r==true){
            alert('등록 되었습니다.');
            tcontent = ``;
            getContent();
        }
        else{
            alert('등록실패 시스템오류')
        }
    } ,
    error : e =>{}
    })

}

// 2. GET
function getContent(){

    console.log('getContent 실행');

   let todo_bottom = document.querySelector('.todo_bottom');
   let html = ``;

    $.ajax({
    url : "http://localhost:8080/todo",
    method : "get",
    data : {},
    success : r => {
        console.log(r);
        r.forEach(e => {

            html += `
                    <div class = "todo ${e.tstate == true ? "successTodo" : ""}">
                        <div class = "tcontent" >
                            ${e.tcontent}
                         </div>
                        <div class="etcbtns">
                            <button onclick="onPut( ${e.tno} , ${e.tstate})" type="button">상태변경</button>
                            <button onclick="onDelete(${e.tno})" type="button">제거하기</button>
                        </div>
                     </div>
                     `;

        });
        todo_bottom.innerHTML = html;
    },
    error : e =>{ console.log(e);}
    });// ajax end
} // getContent end
getContent();
// 3. PUT
function onPut(tno , tstate) {

    let newTstate = false;

    tstate == false ? newTstate = true : newTstate = false;

    let putObject = { tno : tno, tstate : newTstate};

    $.ajax({
    url : "http://localhost:8080/todo",
    method : "put",
    dataType : "json",
    contentType : "application/json",
    data : JSON.stringify(putObject),
    success : r => {
        console.log(r);
        if(r==true){
            alert("수정 되었습니다.")
            getContent();
        }
    } ,
    error : e =>{}
    });

}

// 4. DELETE

function onDelete(tno) {

    $.ajax({
        url : "http://localhost:8080/todo",
        method : "delete",
        data : {tno:tno},
        success : r => {
            alert("삭제 되었습니다.")
            getContent();
        } ,
        error : e =>{}
        })

}