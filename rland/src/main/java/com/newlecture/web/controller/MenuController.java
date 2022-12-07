package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private MenuService service;
	
	public MenuController() {
		
	}
   
   public MenuController(MenuService service) {
		this.service = service;
	}

   @Autowired
	public void setService(MenuService service) {
		this.service = service;
	}

   @GetMapping("/list")
   public String list(Model model) {
      
      model.addAttribute("data", "hello");
      service.getList();
      
      return "menu/list";
   }
}