package com.newlecture.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.newlecture.web.entity.Member;

@Mapper
public interface MemberDao {
    Member getByUserName(String username);

}
