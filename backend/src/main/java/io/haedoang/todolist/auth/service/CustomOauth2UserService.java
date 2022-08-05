package io.haedoang.todolist.auth.service;

import io.haedoang.todolist.auth.domain.OAuth2UserInfo;
import io.haedoang.todolist.auth.domain.OAuth2UserInfoFactory;
import io.haedoang.todolist.auth.domain.ProviderType;
import io.haedoang.todolist.user.domain.User;
import io.haedoang.todolist.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("attributes : {}", super.loadUser(userRequest).getAttributes());
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("oAuth2User: {}", oAuth2User);


        process(userRequest, oAuth2User);

        return oAuth2User;
    }

    //인증을 요청하는 사용자에 따라서 없는 회원이면 회원가입, 이미 존재하는 회원이면 업데이트를 실행한다.

    @Transactional
    public User process(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        ProviderType providerType = ProviderType.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
        log.info("providerType : {}", providerType);

        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, oAuth2User.getAttributes());
        log.info("oAuth2UserInfo: {}", oAuth2UserInfo);


        User user = userRepository.findByEmail(oAuth2UserInfo.getEmail());

        if (Objects.isNull(user)) {
            return userRepository.save(oAuth2UserInfo.toEntity());
        }

        // 매번 업데이트가 될 것 같음
        user.update(oAuth2UserInfo.toEntity());

        return user;
    }
}
