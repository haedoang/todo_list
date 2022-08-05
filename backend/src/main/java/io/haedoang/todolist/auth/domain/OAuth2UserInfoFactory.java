package io.haedoang.todolist.auth.domain;

import java.util.Map;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(ProviderType providerType, Map<String, Object> attributes) {
        switch (providerType) {
            case GOOGLE: return new GoogleOauth2UserInfo(attributes);
            case GITHUB: return new GithubOauth2UserInfo(attributes);
            case KAKAO: return new KakaoOauth2UserInfo(attributes);
            case NAVER: return new NaverOauth2UserInfo(attributes);
            default: throw new AssertionError();
        }
    }
}
