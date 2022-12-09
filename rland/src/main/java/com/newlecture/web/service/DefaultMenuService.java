package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.MenuDao;
import com.newlecture.web.entity.Menu;

@Service
public class DefaultMenuService implements MenuService{

	@Autowired
	private MenuDao menuDao;
	
	public DefaultMenuService() {
		
	}

	public DefaultMenuService(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> getList() {
		List<Menu> list = menuDao.getList(0, 10, "name", "아");
		System.out.println(list);
		
		return list;
	}

	@Override
	public int addToBasket(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
