package com.newlecture.web.entity;

import java.util.Map;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class RlandOidcUser extends RlandUserDetails implements OidcUser{

   public RlandOidcUser() {
      
   }

   public RlandOidcUser(OidcUser oidcUser) {

   }

   @Override
   public Map<String, Object> getAttributes() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getName() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Map<String, Object> getClaims() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public OidcUserInfo getUserInfo() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public OidcIdToken getIdToken() {
      // TODO Auto-generated method stub
      return null;
   }

}
