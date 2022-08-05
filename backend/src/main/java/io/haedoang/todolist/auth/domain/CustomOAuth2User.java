package io.haedoang.todolist.auth.domain;

import io.haedoang.todolist.user.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
@Getter
public class CustomOAuth2User implements OAuth2User {
    private User user;

    private Map<String, Object> attributes;

    public CustomOAuth2User(User user) {
        super();
        this.user = user;
    }

    public CustomOAuth2User(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return user.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
}
