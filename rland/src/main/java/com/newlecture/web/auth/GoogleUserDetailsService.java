package com.newlecture.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.newlecture.web.dao.RoleDao;

public class GoogleUserDetailsService extends DefaultOAuth2UserService {

   @Autowired
   private RoleDao roleDao;
   
   @Override
   public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
      
      OAuth2User user = super.loadUser(userRequest);

      return user;
   }
   
}
