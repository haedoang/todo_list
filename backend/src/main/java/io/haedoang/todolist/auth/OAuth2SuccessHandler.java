package io.haedoang.todolist.auth;

import io.haedoang.todolist.auth.domain.CustomOAuth2User;
import io.haedoang.todolist.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
@Slf4j
@Component
public class OAuth2SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final int COOKIE_EXPIRED_SECOND = 180;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("successhandler invoke");
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();


        CookieUtil.addCookie(response, "username", oAuth2User.getUser().getUsername(), COOKIE_EXPIRED_SECOND);
        CookieUtil.addCookie(response, "email", oAuth2User.getUser().getEmail(), COOKIE_EXPIRED_SECOND);
        CookieUtil.addCookie(response, "profile_image_url", oAuth2User.getUser().getProfileImageUrl(), COOKIE_EXPIRED_SECOND);
        getRedirectStrategy()
                .sendRedirect(request, response, "http://localhost:3000/oauth2/redirect");
    }
}
