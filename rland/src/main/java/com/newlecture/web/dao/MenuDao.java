package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Menu;

@Mapper
public interface MenuDao {
	
	//메뉴 검색
	//'%'name'%'
	//@Select("select * from Menu where name like '%#{query}%'")
	//'%name%'
	//@Select("select * from Menu where name like '%${query}%'")
	List<Menu> getList(
			int page, 
			String field,
			String query);
	
	//한가지 메뉴 검색
	Menu get(int id);
	//검색 수 출력
	int count(String query);
	
	int insert(Menu menu);
	int update(Menu menu);
	int delete(int id);
}
