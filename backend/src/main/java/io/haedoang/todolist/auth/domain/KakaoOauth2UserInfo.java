package io.haedoang.todolist.auth.domain;

import java.util.Map;
import java.util.Objects;

import static io.haedoang.todolist.auth.domain.ProviderType.*;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
public class KakaoOauth2UserInfo extends OAuth2UserInfo {
    public KakaoOauth2UserInfo(Map<String, Object> attributes) {
        super(KAKAO, attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getUsername() {
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        return Objects.nonNull(properties) ? (String) properties.get("nickname") : null;
    }

    @Override
    public String getEmail() {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        return Objects.nonNull(kakaoAccount) ? (String) kakaoAccount.get("email") : null;
    }

    @Override
    public String getImageUrl() {
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        return Objects.nonNull(properties) ? (String) properties.get("thumbnail_image") : null;
    }
}
