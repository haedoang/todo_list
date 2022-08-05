package io.haedoang.todolist.auth.domain;

import java.util.Map;
import java.util.Objects;

import static io.haedoang.todolist.auth.domain.ProviderType.*;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
public class NaverOauth2UserInfo extends OAuth2UserInfo {
    public NaverOauth2UserInfo(Map<String, Object> attributes) {
        super(NAVER, attributes);
    }

    @Override
    public String getId() {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return Objects.nonNull(response) ? (String) response.get("id") : null;
    }

    @Override
    public String getUsername() {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return Objects.nonNull(response) ? (String) response.get("name") : null;
    }

    @Override
    public String getEmail() {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return Objects.nonNull(response) ? (String) response.get("email") : null;
    }

    @Override
    public String getImageUrl() {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return Objects.nonNull(response) ? (String) response.get("profile_image") : null;
    }
}
