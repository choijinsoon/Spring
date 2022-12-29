package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.entity.Cart;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.Menu;

@Mapper
public interface MenuDao {
	
	//메뉴 검색
	//'%'name'%'
	//@Select("select * from Menu where name like '%#{query}%'")
	//'%name%'
//	//@Select("select * from Menu where name like '%${query}%'")
//	List<Menu> getList(
//			int offset,
//			int size,
//			String field,
//			String query);
	List<Menu> getList();
	List<Menu> getList(int offset, int size);
	List<Menu> getList(int offset, int size, Integer categoryId);
	
	//한가지 메뉴 검색
	Menu get(int id);
	//검색 수 출력
	int count(String query);
	
//	insert의 경우는 삽입된 행의 개수를 반환
//	update의 경우는 수정에 성공한 행의 개수를 반환(실패시 0 반환)
//	delete의 경우는 삭제한 행의 개수를 반환(실패시 0 반환)
	
	int insert(Menu menu);
	
	@Transactional(propagation = Propagation.MANDATORY)
	int update(Menu menu);
	int updateAll(Menu[] menus);
	
	int deleteAll(int[] ids);
	void add();
	void add(Cart cart);


    void add(Menu menu);
    Menu getLast();

	int delete(int id);
	

}
