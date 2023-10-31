import styles from '../../css/login.css'
import axios from 'axios';
import { useState } from 'react';

export default function Signup( props ){

    // 1. 회원가입 버튼을 클릭했을때.
    const onSignup = (e) => {
       console.log(e);
       // 2. 입력받은 데이터 구성
       let info ={
        memail : document.querySelector('.memail').value ,
        mpassword : document.querySelector('.mpassword').value ,
        mname : document.querySelector('.mname').value ,
        mphone : document.querySelector('.mphone').value
       }; console.log(info)

       // 3. 통신
       axios
            .post( '/member/post' , info )
            .then( r => {
                if(r.data == true){
                    alert('회원가입 성공')
                    window.location.href="/login";
                }
                else{
                    alert('회원가입 실패')
                }
            })


    }

    let [ memail , setMemail ] = useState('');
    let [ memailCheck , setMemailCheck ] = useState('');

    const emailInputChange = (e) => {

        let memail = e.target.value;
        setMemail( memail );
        //--------------//
        axios
            .get('/member/findMemail' , { params : { 'memail' : memail } }) // 쿼리스트링 형식
            .then( r=> {
                if(r.data ){ setMemailCheck('사용중인 아이디 입니다.') }// 중복 입니다.
                else{ setMemailCheck('사용 가능한 아이디 입니다.') }// 중복아님
             } )

    }

    return(<>
        <div className="loginContainer">
            <h3>ReactEzen Signup</h3>
            <form>
                이메일 : <input type='text'
                         placeholder='@포함 7~30글자'
                         className='memail'
                         onChange={emailInputChange}/>
                <div>{ memailCheck }</div>
                비밀번호 :  <input type='password' placeholder='특수문자조합 5~30글자' className='mpassword' />
                비밀번호 확인 :  <input type='password' placeholder='특수문자 조합 5~30 글자' className='mpassword2' />
                이름 : <input type='text' placeholder='이름' className='mname' />
                전화번호 : <input type='text' placeholder='연락처' className='mphone' />
                <button onClick={onSignup} type="button">회원가입</button>
            </form>
        </div>
    </>)
}