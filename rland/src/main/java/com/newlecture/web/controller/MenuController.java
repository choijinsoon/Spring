package com.newlecture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService service;

	public MenuController() {

	}

	public MenuController(MenuService service) {
		this.service = service;
	}

	public void setService(MenuService service) {
		this.service = service;
	}

	@GetMapping("/list")
	public String list(
			@RequestParam(defaultValue = "1", name = "p") int page, 
			Model model) {

//	   service.testTS();
		int countInCart = service.countOfMenuInCart(1);
		
		List<Menu> list = service.getList(page);
		model.addAttribute("list", list);
		model.addAttribute("countInCart", countInCart);

		return "menu/list";
	}
	
	@PostMapping("/list")
	public String list(
			@RequestParam("menu-id") int menuId, 
			boolean ice, 
			boolean large) {
		
		service.addToCart(1, menuId, ice, large);
		
		System.out.printf("menuId:%d, ice:%s, large:%s\n", menuId, ice, large);

		return "redirect:list";
	}

	@GetMapping("/detail")
	public String detail(Model model) {

//	   service.testTS();

//      model.addAttribute("data", "hello");
//      service.getList();

		return "menu/detail";
	}
}