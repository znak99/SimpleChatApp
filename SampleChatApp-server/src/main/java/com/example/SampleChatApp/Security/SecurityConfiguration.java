package com.example.SampleChatApp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .antMatchers("/h2-console/**");

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        return http.authorizeRequests()


                            //구획별 설정
                //------------------------------------------
                // 회원 관리 처리 API 전부를 login 없이 허용

                .antMatchers("/").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/signup/**").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/checkMail").permitAll()
                .antMatchers("/api/reset-password").permitAll()
                //그 외 나머지는 로그인으로 인증을 받아야 이용가능
                .anyRequest().authenticated()

                //------------------------------------------
                .and()
                //------------------------------------------
                //로그인 설정
                .formLogin()
                .usernameParameter("email")
                .loginProcessingUrl("/api/signin")
                .successHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write("{\"success\": true}");
                }))
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write("{\"success\": false, \"message\": \"" + exception.getMessage() + "\"}");
                })
                .permitAll()

                //------------------------------------------
                .and()
                //------------------------------------------

                .logout()
                // 로그아웃 요청 처리 URL
                .logoutUrl("/api/logout")
                .permitAll()

                //------------------------------------------
                .and()
                //------------------------------------------

                // 로그인 유지 시간
                .rememberMe()
                // 초 단위 1시간
                .tokenValiditySeconds(60*60)

                //------------------------------------------
                .and()
                //------------------------------------------

                //예외처리 구성을 설정하는 메소드
                .exceptionHandling()
                // "접근 불가" 페이지 URL 설정
                .accessDeniedPage("/forbidden.html")

                .and()
                .build();
    }
}
