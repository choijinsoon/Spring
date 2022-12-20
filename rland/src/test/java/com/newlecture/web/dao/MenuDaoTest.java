package com.newlecture.web.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
class MenuDaoTest {

	@Autowired
	private MenuDao menuDao;
	
//	@Test
//	void testGetList() {
//		System.out.println(menuDao);
//		int offset = 0;
//		int size = 10;
//		System.out.println(menuDao.getList(offset, size,  "name", "카"));
////		fail("Not yet implemented");
//	}

}
