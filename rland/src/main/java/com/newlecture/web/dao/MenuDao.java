package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Menu;

@Mapper
public interface MenuDao {
	
	//'%'name'%'
	//@Select("select * from Menu where name like '%#{query}%'")
	//'%name%'
	//@Select("select * from Menu where name like '%${query}%'")
	List<Menu> getList(String query);
	
	Menu get();
	int count();
	
	int insert();
	int update();
	int delete();
}
