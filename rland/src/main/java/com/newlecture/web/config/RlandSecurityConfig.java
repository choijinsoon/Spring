package com.newlecture.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RlandSecurityConfig {

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
         .csrf()
            .disable()
         .authorizeHttpRequests(auth->auth
            .requestMatchers("/admin/**").hasAnyRole("ADMIN") //ROLE 권한이 있으면 URI를 허용
            .requestMatchers("/member/**").hasAnyRole("ADMIN,MEMBER")
            .anyRequest().permitAll()
         )
         // .httpBasic();
         .formLogin(form->form
            .loginPage("/user/login")  //URI에서 로그인을 하고 성공하면 index로 이동
            .defaultSuccessUrl("/index"))
         .logout(form->form
            .logoutUrl("/user/logout") //URI 접속하면 index로 이동
            .logoutSuccessUrl("/index"));

      return http.build();
   }

   @Bean //사용자의 목록
   public UserDetailsService userDetailsService() {
      UserDetails admin = User.builder().username("admin").password("admin").roles("ADMIN").build();
      UserDetails dragon = User.builder().username("dragon").password("dragon").roles("MEMBER").build();
      UserDetails member = User.builder().username("member").password("member").roles("MEMBER").build();
      
      return new InMemoryUserDetailsManager(admin, dragon, member);

   }
}

