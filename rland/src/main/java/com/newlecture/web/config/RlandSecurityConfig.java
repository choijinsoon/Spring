package com.newlecture.web.config;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.newlecture.web.auth.RlandUserDetailsService;
import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.RlandOidcUser;

@Configuration
public class RlandSecurityConfig {

   @Autowired
   private DataSource datasource;

   @Autowired
   private MemberDao memberDao;

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
         .csrf()
            .disable()
         .authorizeHttpRequests(auth->auth
            .requestMatchers("/admin/**").hasAnyRole("ADMIN","CORP") //ROLE 권한이 있으면 URI를 허용
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
         )
         .oauth2Login(oauth2->oauth2
            .userInfoEndpoint()
               // .userAuthoritiesMapper(this.userAuthoritiesMapper()
               .oidcUserService(oidcUserService())
               
         )
         ;


      return http.build();
   }

   // OicdUser info
   private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService(){

      OidcUserService userService = new OidcUserService();

      return (odicUserRequest)->{
         OidcUserService oidcUserService = new OidcUserService();
         OidcUser oidcUser = oidcUserService.loadUser(odicUserRequest);

         System.out.println("=====user info======");
         System.out.println(oidcUser);
         System.out.println("=====user attributes info======");
         System.out.println(oidcUser.getAttributes());

         // OidcUser(Google 사용자 정보) -> RlandOidcUser(DB 사용자 정보)
         Set<GrantedAuthority> mappedAuthorities = new HashSet<GrantedAuthority>();

         RlandOidcUser user = new RlandOidcUser(oidcUser);
         
         Member member = memberDao.getByOAuthIdWithIss(oidcUser.getName(), (String) oidcUser.getAttribute("iss"));
         
         // 새로운 사용자
         if(member == null){ 
            Member temp = memberDao.getByUserName(oidcUser.getAttribute("NAME"));

            String username = oidcUser.getAttribute("NAME")+"_1";

            // DB에 동일한 이름이 있을경우
            if(temp != null)
               username += "_1";

            temp = new Member();

            temp.setEmail(oidcUser.getEmail());
            temp.setUsername(username);
            temp.setOAuthId(oidcUser.getName());
            temp.setOAuthIss(oidcUser.getAttribute("ISS"));

            
            memberDao.add(temp);
         }

         // user.setEmail(member.getEmail());
         // user.setId(member.getId());
         // user.setUsername(username);
         // user.setPassword(member.getPwd());
         // user.setAuthorites(auth);

         return user; 
         // new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
      };
   }

   // oauth2 권한 처리
   private GrantedAuthoritiesMapper userAuthoritiesMapper() {
      return (authorities) -> {
         Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
         authorities.forEach(authority -> {
            if (OidcUserAuthority.class.isInstance(authority)) {
               OidcUserAuthority oidcUserAuthority = (OidcUserAuthority)authority;

               OidcIdToken idToken = oidcUserAuthority.getIdToken();
               OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();

               //ROLE_ADMIN 설정
               mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
               
            } else if (OAuth2UserAuthority.class.isInstance(authority)) {
               OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority)authority;

               Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();

            }
         });

         return mappedAuthorities;
      };
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
      
      // Role 테이블이 없을 경우
      // manager.setAuthoritiesByUsernameQuery("select username, 'ROLE_ADMIN' authority from Member where username=?");

      // Role 테이블이 있을 경우
      manager.setAuthoritiesByUsernameQuery("select username, r.name authority from Member where username=?");

      
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

