package com.oauth.poc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .cors().disable()
      .csrf().disable()
      .authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .oauth2Login().loginPage("/oauth2/authorization/auth0");
  }

}
