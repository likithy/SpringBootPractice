package com.practice.practiceWebApp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    UserDetails userDetails = createNewUser("likith", "1234");
    UserDetails userDetails1 = createNewUser("likith1", "test");
    return new InMemoryUserDetailsManager(userDetails,userDetails1);
  }

  public UserDetails createNewUser(String userName, String password) {

    return User.builder()
        .passwordEncoder(input -> encodePassword().encode(input))
        .username(userName)
        .password(password)
        .roles("USER", "ADMIN")
        .build();
  }

  private static String getUsername() {
    return "likith";
  }

  @Bean
  public PasswordEncoder encodePassword() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
            auth->auth.anyRequest().authenticated());
    httpSecurity.formLogin(withDefaults());
    httpSecurity.csrf(csrf->csrf.disable());
    httpSecurity.headers(header->header.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
    return httpSecurity.build();
  }
}
