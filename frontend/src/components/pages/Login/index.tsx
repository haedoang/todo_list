import { OAUTH2_GOOGLE_AUTH, OAUTH2_GITHUB_AUTH, OAUTH2_KAKAO_AUTH, OAUTH2_NAVER_AUTH } from 'utils/URI';
import Main from 'components/pages/Main';
interface LoginProps {
    setToken: React.Dispatch<React.SetStateAction<string>>;
}


function Login({ setToken }: LoginProps) {
    return (
        <>
            <h3>loginPage</h3>
            <a href={OAUTH2_GOOGLE_AUTH}>구글 아이디로 로그인</a>
            <a href={OAUTH2_GITHUB_AUTH}>깃허브 아이디로 로그인</a>
            <a href={OAUTH2_NAVER_AUTH}>네이버 아이디로 로그인</a>
            <a href={OAUTH2_KAKAO_AUTH}>카카오 아이디로 로그인</a>

            <hr/>

            <Main />
        </>
    )
}

export default Login;