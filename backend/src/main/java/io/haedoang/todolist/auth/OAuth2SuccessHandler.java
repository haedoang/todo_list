package io.haedoang.todolist.auth;

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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("successhandler invoke");


        getRedirectStrategy()
                .sendRedirect(request, response, "http://localhost:3000/oauth2/redirect");
    }
}
