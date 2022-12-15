package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.entity.Cart;
import com.newlecture.web.entity.Menu;

@Mapper
public interface CartDao {
	void add(Cart cart);
	
	int count(int memberId);
		
}