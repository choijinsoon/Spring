package com.newlecture.web.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.RoleDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.RlandUserDetails;
import com.newlecture.web.entity.Role;

public class RlandUserDetailsService implements UserDetailsService {

   @Autowired
   private MemberDao memberDao;

   @Autowired
   private RoleDao roleDao;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Member member = memberDao.getByUserName(username);
      List<Role> roles = roleDao.getListByUserName(username);

      //사용자가 가지고 있는 role 가져오기
      List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();

      //role을 객체에 담아준다
      for (Role r : roles) {
         auth.add(new SimpleGrantedAuthority(r.getName()));
      }


      RlandUserDetails user = new RlandUserDetails();
      user.setEmail(member.getEmail());
      user.setId(member.getId());
      user.setUsername(username);
      user.setPassword(member.getPwd());

      user.setAuthorites(auth);
      
      return user;
   }
   
}
