
export const API_BASE_URL = 'http://localhost:8080';
export const OAUTH2_REDIRECT_URI =  'http://localhost:8080/oauth2/redirect';
export const OAUTH2_GOOGLE_AUTH =  `${API_BASE_URL}/oauth2/authorization/google?redirect_uri=${OAUTH2_REDIRECT_URI}`
export const OAUTH2_GITHUB_AUTH =  `${API_BASE_URL}/oauth2/authorization/github?redirect_uri=${OAUTH2_REDIRECT_URI}`
export const OAUTH2_NAVER_AUTH =  `${API_BASE_URL}/oauth2/authorization/naver?redirect_uri=${OAUTH2_REDIRECT_URI}`
export const OAUTH2_KAKAO_AUTH =  `${API_BASE_URL}/oauth2/authorization/kakao?redirect_uri=${OAUTH2_REDIRECT_URI}`