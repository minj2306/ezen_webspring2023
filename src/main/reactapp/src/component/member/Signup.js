export default function Signup( props ){
    return(<>
        <form>
            이메일[아이디] : <input type='text' /><br />
            비밀번호 :  <input type='password' /><br />
            비밀번호 확인 :  <input type='password' /><br />
            이름 : <input type='text' /><br />
            전화번호 : <input type='text' /><br />
            <button type="button">회원가입</button>
        </form>
    </>)
}