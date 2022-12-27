package com.newlecture.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

@Service
public class DefaultMemberService implements MemberService {

   @Autowired
   private MemberDao dao;

   public Member getMemberByUserName(String username){
      return dao.getByUserName(username);

   };

   
}