package com.teamproject.gaxga.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // h2-console 사용 위해서
    @Bean
    @ConditionalOnProperty(name = "spring.h2.console.enabled",havingValue = "true")
    public WebSecurityCustomizer configureH2ConsoleEnable() {
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toH2Console());
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**",
                                "/fonts/**", "/login", "/joinMembership",
                                "/joinMembership/create", "main/main2", "/myPage.html").permitAll()
                        .anyRequest().authenticated()); // todo. 임시로 로그인 후에는 모든 요청에 접근을 허용하게 했으나 나중에 로그인 후에 보여줄거 같은거 수정필요
        http
                .formLogin((auth) -> auth.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("gaId")
                        .passwordParameter("gaPass")
                        .permitAll()
                        .defaultSuccessUrl("/main2", true)
                );
        http
                .logout((logout) -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                // 성공하면 루트 페이지로 이동
                .logoutSuccessUrl("/main2")
                // 로그아웃 시 생성된 사용자 세션 삭제
                .invalidateHttpSession(true));
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }
}
