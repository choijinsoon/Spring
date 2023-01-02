package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.newlecture.web.auth.GoogleUserDetailsService;
import com.newlecture.web.auth.RlandUserDetailsService;

// @Configuration
public class GoogleSecurityConfig {

   @Autowired
   private DataSource datasource;

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
         .csrf()
            .disable()
         .authorizeHttpRequests(auth->auth
            .requestMatchers("/admin/**").hasAnyRole("ADMIN","CORP") //ROLE 권한이 있으면 URI를 허용
            .requestMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
            .anyRequest().permitAll())
         .oauth2Login()
         ;


      return http.build();
   }

   @Bean
   public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();

   }

   @Bean
   public GoogleUserDetailsService googleUserDetailsService(){
      return new GoogleUserDetailsService();
   }
}

