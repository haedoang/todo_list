package io.haedoang.todolist.config;

import io.haedoang.todolist.auth.OAuth2SuccessHandler;
import io.haedoang.todolist.auth.Oauth2AuthenticationFailureHandler;
import io.haedoang.todolist.auth.service.CustomOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * author : haedoang
 * date : 2022-08-04
 * description :
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOauth2UserService customOauth2UserService;
    private final OAuth2SuccessHandler successHandler;
    private final Oauth2AuthenticationFailureHandler failureHandler;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
//                        .exceptionHandling()
//                        .authenticationEntryPoint()
//                        .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2Login()
                .authorizationEndpoint()
                .and()
                .redirectionEndpoint()
                .baseUri("/login/oauth2/code/*")
                .and()
                .userInfoEndpoint()
                .userService(customOauth2UserService)
                .and()
                .successHandler(successHandler)
                .failureHandler(failureHandler);

        return http.build();
    }
}
