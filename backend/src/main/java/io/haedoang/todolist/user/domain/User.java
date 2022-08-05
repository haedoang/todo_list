package io.haedoang.todolist.user.domain;

import io.haedoang.todolist.auth.domain.ProviderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
@Getter
@Entity
@Table(name = "tb_user")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private ProviderType providerType;

    private String username;

    private String email;

    private String profileImageUrl;

    private User(ProviderType providerType, String username, String email, String profileImageUrl) {
        this.providerType = providerType;
        this.username = username;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    public void update(User updateUser) {
        this.providerType = updateUser.providerType;
        this.username = updateUser.username;
        this.email = updateUser.email;
        this.profileImageUrl = updateUser.profileImageUrl;
    }

    public static User valueOf(ProviderType type, String username, String email, String profileImageUrl) {
        return new User(type, username, email, profileImageUrl);
    }
}
