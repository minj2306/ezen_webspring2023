import styles from '../../css/login.css'
import axios from 'axios';
import { useState , useEffect } from 'react';

export default function Info( props ){


    /*axios
        .get('/member/get')
        .then( r => {
            console.log(r.data);
            if(r.data != ''){ // 만약 로그인이 되어있으면
                let memail = r.data.memail;
                let mname = r.data.mname;
                let mphone = r.data.mphone;

                document.querySelector('.memail').value = memail;
                document.querySelector('.mname').value = mname;
                document.querySelector('.mphone').value = mphone;

            }
        })*/

    const [ member, setMember ] = useState(null); // 예) { memail : 'qqq', mname : 'www', mphone : '111' }
    useEffect(() => {
        axios
            .get('/member/get')
            .then( r => {
                setMember(r.data);
            })
    } , [] )

    // 이름 입력했을때 상태 변경 함수
    const mnameInputChange = (e) => {

        console.log(e.target.value); // onchange 이벤트를 실행한 주체자[e.target] 의 값 호출 [.value]
        let mnameInput = e.target.value;
        //setMember( mnameInput ); // 문제점
        // member 상태변수에 전체수정이 아닌 member 상태변수내 특정 속성만 변경 해야함
        // member 상태변수 특정 속성만 교체.. member 객체중에 mname 속성만 교체
        /*
        let changeMember = member // 기존 객체를 새로운 객체에 대입
        changeMember.mname = mnameInput; // 객체의 특정 속성만 새로운 값 대입
        setMember(changeMember); // 수정된 새로운 객체를 상태변수에 대입
        */
        /*
            // 문제점 : setState() 는 상태 변수의 주소값이 변경될때 반응/ 랜더링 [ ...배열명 ]
        let changeMember = { ...member } // 기존 객체를 새로운 객체에 대입
            // !! : 1. 객체복사 방법      2. 배열 복사 방법
            // ...Spread Operator : 얕은 복제
            // { ...객체명 , 속성명 : 값 } // 복사할떄 해당 속성명이 있으면 수정 / 없으면 대입
        changeMember.mname = mnameInput; // 객체의 특정 속성만 새로운 값 대입
        setMember(changeMember); // 수정된 새로운 객체를 상태변수에 대입
        */
        setMember( {...member , mname : mnameInput} )

    }

    // 전화번ㄴ호 변경 [ 바로 이벤트 속성 처리 ]
    /*const mphoneInputChange = (e) => {

        let phoneInput = e.target.value;
        setMember( { ...member , mphone : phoneInput } )
    }*/

    // 회원탈퇴
    const onDelete = (e) => {

        if(window.confirm('정말 탈퇴 하시겠습니까?')){
            axios
                .delete('/member/delete' , {params: { mno : member.mno }})
                .then( r => {

                    if(r.data){
                        alert('회원탈퇴 성공');
                        sessionStorage.removeItem('login_token'); // 로그인 세션 제거
                        window.location.href="/";
                    }
                    else{
                        alert('회원탈퇴 실패 (시스템오류)')
                    }
                })
        }
    }

    // 4. 회원정보 수정
    const [ newPassword , setNewPassword ] = useState( { mpassword: '' , mpassword2 : '' } );
    const onUpdate = (e) => {

        // 기존 비밀번호가 일치한지 유효성 검사[x] --->백엔드 해야할 일
        // 새로운 비밀번호 2개 일치한지 유효성 검사 ---> 프론트엔드 해야할 일
        if( newPassword.mpassword != newPassword.mpassword2 ){ return; }

        let info = { mno : member.mno ,
                     mpassword : newPassword.mpassword == '' ? member.mpassword : newPassword.mpassword ,
                     mname : member.mname ,
                     mphone : member.mphone
                   }; console.log( info ); // 수정할 정보들이 저장된 객체 확인

        axios.put('/member/put' , info )
             .then( r => {
                if(r.data){
                    alert('정보 수정 되었습니다. 다시 로그인 해주세요');
                    sessionStorage.removeItem('login_token');
                    window.location.href="/login";
                }
                else{
                    alert('정보 수정 실패 (시스템오류)')
                }
             })

    }

    return(<>
        <div className="loginContainer">
            <h3>ReactEzen Signup</h3>
            <form>
                회원등급<div>{ member != null ? member.mrol : '' }</div>
                이메일 : <input value ={ member != null ? member.memail : '' } disable type='text'
                         placeholder='@포함 7~30글자'
                         className='memail'
                         />
                새 비밀번호 :  <input
                              type='password'
                              placeholder='특수문자조합 5~30글자'
                              className='mpassword'
                              value ={ newPassword.mpassword }
                              onChange={ (e) => setNewPassword({ ...newPassword , mpassword : e.target.value }) }
                              />
                새 비밀번호 확인 :  <input
                                  type='password'
                                  placeholder='특수문자 조합 5~30 글자'
                                  className='mpassword2'
                                  value ={ newPassword.mpassword2 }
                                  onChange={ (e) => setNewPassword({ ...newPassword , mpassword2 : e.target.value }) }
                                  />
                이름 : <input
                        value = { member != null ? member.mname : '' }
                        type='text'
                        placeholder='이름'
                        className='mname'
                        onChange={ mnameInputChange }/>
                전화번호 : <input
                            value = { member != null ? member.mphone : '' }
                            type='text' placeholder='연락처'
                            className='mphone'
                            onChange={ (e) =>{ setMember( { ...member , mphone : e.target.value} ) } }/>
                <button onClick={ onUpdate } type="button">정보 수정</button>
                <button onClick={ onDelete } type="button">회원 탈퇴</button>
            </form>
        </div>
    </>)
}