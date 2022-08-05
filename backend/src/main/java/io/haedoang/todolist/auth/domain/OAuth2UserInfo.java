package io.haedoang.todolist.auth.domain;

import io.haedoang.todolist.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
@Getter
@AllArgsConstructor
public abstract class OAuth2UserInfo {
    private ProviderType providerType;
    protected Map<String, Object> attributes;

    public abstract String getId();

    public abstract String getUsername();

    public abstract String getEmail();

    public abstract String getImageUrl();

    public User toEntity() {
        return User.valueOf(providerType, getUsername(), getEmail(), getImageUrl());
    }
}
