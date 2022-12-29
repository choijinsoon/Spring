package com.newlecture.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.RlandUserDetails;

public class RlandUserDetailsService implements UserDetailsService {

   @Autowired
   private MemberDao memberDao;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Member member = memberDao.getByUserName(username);

      RlandUserDetails user = new RlandUserDetails();
      user.setEmail(member.getEmail());
      user.setId(member.getId());
      user.setUsername(username);
      user.setPassword(member.getPwd());
      
      return user;
   }
   
}
