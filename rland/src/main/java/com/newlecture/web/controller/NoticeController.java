package com.newlecture.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@GetMapping("/list")
	@ResponseBody
	public String list() {
		
		//Model
//		List<String> list = new ArrayList<>();
//		list.add("1111");
//		list.add("2222");
//		list.add("3333");
		
		return "notice/list";
	}
	
	@RequestMapping("/detail")
	public String detail() {
		return "공지내용";
	}
}
