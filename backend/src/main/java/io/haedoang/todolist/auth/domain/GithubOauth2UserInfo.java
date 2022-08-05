package io.haedoang.todolist.auth.domain;

import java.util.Map;

import static io.haedoang.todolist.auth.domain.ProviderType.*;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
public class GithubOauth2UserInfo extends OAuth2UserInfo {
    public GithubOauth2UserInfo(Map<String, Object> attributes) {
        super(GITHUB, attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getUsername() {
        return (String) attributes.get("login");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("avatar_url");
    }
}
