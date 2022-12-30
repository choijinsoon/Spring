package com.newlecture.web.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class RlandUserDetails implements UserDetails {

   private int id;
   private String email;
   private String username;
   private String password;
   private List<GrantedAuthority> authorites;
   

   @Override
   public String toString() {
      return "RlandUserDetails [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
            + "]";
   }

   public void setAuthorites(List<GrantedAuthority> authorites) {
      this.authorites = authorites;
   }
   
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      // List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
      // list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

      // return list;
      return authorites;
   }

   @Override
   public boolean isAccountNonExpired() {
      // TODO Auto-generated method stub
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      // TODO Auto-generated method stub
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      // TODO Auto-generated method stub
      return true;
   }

   @Override
   public boolean isEnabled() {
      // TODO Auto-generated method stub
      return true;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   
}