package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Menu;

public interface MenuService {
   List<Menu> getList();
   List<Menu> getList(int page);
   List<Menu> getListByCategory(int categoryId);
   
   void addToCart(int memberId, int menuId, boolean ice, boolean large);

   int addToBasket(int id);
   
   void testTS();
   
   int countOfMenuInCart(int memberId);
   Menu get(int id);
   Menu getLastOneAfterAdding(String name, String originalFilename, int price);

   int delete(int id);
}