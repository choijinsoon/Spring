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

import com.newlecture.web.service.RlandUserDetailsService;

@Configuration
public class RlandSecurityConfig {

   @Autowired
   private DataSource datasource;

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
         .csrf()
            .disable()
         .authorizeHttpRequests(auth->auth
            .requestMatchers("/admin/**").hasAnyRole("ADMIN") //ROLE 권한이 있으면 URI를 허용
            .requestMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
            .anyRequest().permitAll()
         )
         // .httpBasic();
         .formLogin(form->form
            .loginPage("/user/login")  //URI에서 로그인을 하고 성공하면 index로 이동
            .defaultSuccessUrl("/index")
            // .successHandler(null)
            )
         .exceptionHandling(exp->exp
            .accessDeniedPage("/denied"))
         .logout(form->form
            .logoutUrl("/user/logout") //URI 접속하면 index로 이동
            .logoutSuccessUrl("/index")
            // .logoutSuccessHandler(null)
            );


      return http.build();
   }

   @Bean
   public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();

   }

   @Bean
   public UserDetailsService rlandUserDetailsService(){
      return new RlandUserDetailsService();
   }

   // @Bean //사용자의 목록
   public UserDetailsService jdbcUserDetailsService() {
      JdbcUserDetailsManager manager = new JdbcUserDetailsManager(datasource);
      manager.setUsersByUsernameQuery("select username, pwd password, 1 enabled from Member where username=?");

      manager.setAuthoritiesByUsernameQuery("select username, 'ROLE_ADMIN' authority from Member where username=?");
      return manager;

   }

   //@Bean 사용자의 목록
   public UserDetailsService userDetailsService() {
      UserDetails root = User.builder()
         .username("root")
         .password(passwordEncoder().encode("root"))
         .roles("ADMIN","MEMBER")
         .build();
      UserDetails user = User.builder()
         .username("user")
         .password(passwordEncoder().encode("user"))
         .roles("MEMBER")
         .build();
      
      return new InMemoryUserDetailsManager(root, user);

   }
}

