
interface LoginProps {
    setToken: React.Dispatch<React.SetStateAction<string>>;
}

function Login({ setToken }: LoginProps) {
    return (
        <>
            <h3>loginPage</h3>
            <a href="http://localhost:8080/oauth2/authorization/google">구글 아이디로 로그인</a>
            <a href="http://localhost:8080/oauth2/authorization/github">깃허브 아이디로 로그인</a>
            <a href="http://localhost:8080/oauth2/authorization/naver">네이버 아이디로 로그인</a>
            <a href="http://localhost:8080/oauth2/authorization/kakao">카카오 아이디로 로그인</a>
        </>
    )
}

export default Login;