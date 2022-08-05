package io.haedoang.todolist.auth.domain;

import java.util.Map;

import static io.haedoang.todolist.auth.domain.ProviderType.*;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
public class GoogleOauth2UserInfo extends OAuth2UserInfo {
    public GoogleOauth2UserInfo(Map<String, Object> attributes) {
        super(GOOGLE, attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getUsername() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("picture");
    }
}
