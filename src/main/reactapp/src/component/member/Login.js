export default function Login( props ){
    return(<>
        <form>
            이메일[아이디] : <input type='text' /><br />
            비밀번호 : <input type='password' /><br />
            <button type="button">로그인</button>
        </form>
    </>)
}