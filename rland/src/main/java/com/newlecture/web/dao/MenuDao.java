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
			int offset,
			int size,
			String field,
			String query);
	
	//한가지 메뉴 검색
	Menu get(int id);
	//검색 수 출력
	int count(String query);
	
//	insert의 경우는 삽입된 행의 개수를 반환
//	update의 경우는 수정에 성공한 행의 개수를 반환(실패시 0 반환)
//	delete의 경우는 삭제한 행의 개수를 반환(실패시 0 반환)
	
	int insert(Menu menu);
	int update(Menu menu);
	int updateAll(Menu[] menus);
	
	int delete(int id);
	int deleteAll(int[] ids);
}
