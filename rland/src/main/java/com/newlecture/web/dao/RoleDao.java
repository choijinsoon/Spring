package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.newlecture.web.entity.Role;

@Mapper
public interface RoleDao {

   List<Role> getListByUserName(String username);

}
