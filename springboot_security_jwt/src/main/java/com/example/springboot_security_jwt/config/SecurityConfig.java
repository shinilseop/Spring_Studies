package com.example.springboot_security_jwt.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 기본적인 웹보안 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter { // 웹 보안 추가 설정
  @Override
  public void configure(WebSecurity web){
    // h2-console 관련된 요청과 favicon에 대한 security를 ignore 설정
    web
        .ignoring()
        .antMatchers(
            "/h2-console/**"
            ,"/favicon.ico"
        );
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    // /api/hello 요청은 인증없이, 나머지는 인증이 필요하도록 설정
    http
        .authorizeRequests()
        .antMatchers("/api/hello").permitAll()
        .anyRequest().authenticated();
  }
}
