package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.dao.CartDao;
import com.newlecture.web.dao.MenuDao;
import com.newlecture.web.entity.Cart;
import com.newlecture.web.entity.Menu;

@Service
public class DefaultMenuService implements MenuService{

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private CartDao cartDao;
	
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
//		List<Menu> list = menuDao.getList(0, 10, "name", "아");
		
		return getList(1);
	}
	@Override
	public List<Menu> getList(int page) {
		int size = 6;
		int offset = (page-1)*size;
		
		
		return menuDao.getList(offset, size);
	}

	@Override
	public int addToBasket(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	@Override
	public void testTS() {
		Menu menu = menuDao.get(13);
		menu.setPrice(menu.getPrice()-500);
		menuDao.update(menu);
		
		menu.setPrice(menu.getPrice()-50000);
		menuDao.update(menu);
	}

	public void addToCart(int memberId, int menuId, boolean ice, boolean large) {
		Cart cart = new Cart(memberId,menuId,ice,large);
		cartDao.add(cart);
	}

	@Override
	public int countOfMenuInCart(int memberId) {

		return cartDao.count(memberId); 
	}
	

}
