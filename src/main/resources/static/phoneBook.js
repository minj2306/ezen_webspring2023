console.log("phone.js 열림");

getPhone();
function getPhone(){

    console.log("getPhone 실행");

    let phoneConBox = document.querySelector('.phoneConBox');
    let html = ``;
    $.ajax({
    url : "http://localhost:8080/phone",
    method : "get",
    data : {} ,
    success : r => {

        r.forEach(e => {

            html += `<div class="phone_content">
                          <div class="content_box">
                             <div class="getpname upPname${e.pno}">
                                 이름 : ${e.pname}
                             </div>
                             <div class="getpnumber upPnumber${e.pno}">
                                 전화번호 : ${e.pnumber}
                             </div>
                         </div>
                         <div class="phone_btn upbtn${e.pno}">
                             <button onclick="readyUpdate( ${e.pno} , '${e.pname}' , '${e.pnumber}' )" type="button">수정</button>
                             <button onclick="onDelete(${e.pno})" type="button">삭제</button>
                         </div>
                      </div>
                     `
        }) // foreach end
        phoneConBox.innerHTML = html;

    } ,
    error : e =>{}
    })

}

function onWrite(){

    console.log('onWrite 실행');

    let pname = document.querySelector('.pname');
    let pnumber = document.querySelector('.pnumber');

    if(pname.value == ``){
        alert('이름을 입력해주세요.');
        return;
    }
    else if(pnumber.value == ``){
    alert('전화번호를 입력해주세요.');
    return;
    }
    else if(pnumber.value.length!= 13){
        alert('전화번호는 - 포함 13자리 이어야 합니다.');
        return;
    }

    let phoneObject = { pname : pname.value, pnumber : pnumber.value};

     $.ajax({
        url : "http://localhost:8080/phone",
        method : "post",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(phoneObject),
        success : r => {
            console.log(r);

            alert('등록 되었습니다.');
            pname.value = ``;
            pnumber.value = ``;
            getPhone();

        } ,
        error : e =>{}
        })

}

function readyUpdate( pno , pname , pnumber){

    console.log('readyUpdate 실행');

    let upPname = document.querySelector(`.upPname${pno}`);
    let upPnumber = document.querySelector(`.upPnumber${pno}`);
    let upbtn = document.querySelector(`.upbtn${pno}`);

    upPname.innerHTML = `이름 : <input class="newPname" type="text">`
    upPnumber.innerHTML = `번호 : <input class="newPnumber" type="text">`

    let newPname = document.querySelector('.newPname');
    let newPnumber = document.querySelector('.newPnumber');

    newPname.value = pname;
    newPnumber.value = pnumber;

    upbtn.innerHTML = `<button onclick="onUpdate(${pno})" type="button">수정완료</button>`

}

function onUpdate(pno){

    let newPname = document.querySelector('.newPname').value;
    let newPnumber = document.querySelector('.newPnumber').value;

    if(newPname == ``){
        alert('이름을 입력해주세요.');
        return;
    }
    else if(newPnumber == ``){
        alert('전화번호를 입력해주세요.');
        return;
    }
    else if(newPnumber.length!= 13){
        alert('전화번호는 - 포함 13자리 이어야 합니다.');
        return;
    }

    let updateObject = { pno : pno, pname : newPname, pnumber : newPnumber}

    $.ajax({
        url : "http://localhost:8080/phone",
        method : "put",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(updateObject) ,
        success : r => {
            alert('수정되었습니다')
            getPhone();
        } ,
        error : e =>{}
        })

}

function onDelete(pno){

    console.log('onDelete 실행');

    $.ajax({
    url : "http://localhost:8080/phone",
    method : "delete",
    data : {pno : pno} ,
    success : r => {
        alert('삭제되었습니다.');
        getPhone();
    } ,
    error : e =>{}
    })
}