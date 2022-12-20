package com.newlecture.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;

// /api/menus/cate/2
@RestController
@RequestMapping("/api")
public class MenuApi {
	
	@Autowired
	private MenuService service;
	
	@GetMapping("/menus")
	public List<Menu> list(@RequestParam("c") int category) {
		List<Menu> list = service.getListByCategory(category);
		return list;
	}
	
	
	@GetMapping("/menus/{id}")
	public String item(@PathVariable("id") int id) {
		return "";
	}
}
