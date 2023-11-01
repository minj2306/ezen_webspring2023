import {Link} from 'react-router-dom';
import styles from '../../css/login.css';
import axios from 'axios';

export default function Login( props ){

   // 1. 로그인 버튼을 클릭했을때


   function onLogin(e){
        console.log(e)
        //2. axios를 이용한 restAPI 로 spring Controller 데이터 전달

        /* 데이터 구성 [ json ]
        let info = {
            memail : document.querySelector('.memail').value ,
            mpassword : document.querySelector('.mpassword').value
        }; console.log(info);
        */

        // 데이터 구성[ form ]
        let loginForm = document.querySelectorAll('.loginForm')[0];
        let loginFromData = new FormData(loginForm);


        // 4. Axios 통신 [ Spring Controller 매핑 확인후 ]
        axios
            .post( '/member/login' , loginFromData )
            .then( r => {
                console.log(r.data);

                if( r.data == true ){
                    alert('로그인 성공')
                    window.location.href="/";
                }
                else{
                    alert('로그인 실패')
                }
            })
            // CORS policy 오류 발생 해결 방안
                // - 스프링 controller 클래스 @CrossOrigin("/http://localhost:3000")

   }

    return(<>
        <div className="loginContainer">
            <h3>ReactEzen Login</h3>
            <form className="loginForm">
                아이디 : <input type='text' placeholder='email address'
                            name='memail' className="memail" id="memail" /><br />

                비밀번호 : <input type='password' placeholder='password'
                            name='mpassword' className="mpassword" id="mpassword" /><br />

                {/*Link 컴포넌트 사용하려면 import*/}

                <Link to=''>아이디 찾기</Link> <Link to=''>비밀번호 찾기</Link>

                <button type="button" onClick={ onLogin } >로그인</button>
                <a className="kakaoBtn" href="/oauth2/authorization/kakao">카카오 1초 로그인</a>
                <a className="naverBtn" href="/oauth2/authorization/naver">네이버 1초 로그인</a>
                <a className="googleBtn" href="/oauth2/authorization/google">구글 1초 로그인</a>

            </form>
        </div>
    </>)
}

/*
            <form action="전송할 HTTP 주소 " method ="HTTP 메소드">
                아이디 : <input type='text' placeholder='email address' className='memail' /><br />
                비밀번호 : <input type='password' placeholder='password' className='mpassword'/><br />
                {*//*Link 컴포넌트 사용하려면 import*//*}
                <Link to=''>아이디 찾기</Link> <Link to=''>비밀번호 찾기</Link>
                <button type="button">로그인</button>
            </form>
*/