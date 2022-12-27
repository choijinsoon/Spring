package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/login")
	public String login() {

		return "/user/login";
	}

	@PostMapping("/login")
	public String login(
		String username, 
		String pwd, 
		String returnURL, 
		HttpSession session) {

		System.out.println("returnURL:"+returnURL);



		Member member = service.getMemberByUserName(username);

		System.out.println(member);
		if(member == null)
			return "redirect:login?error";
		else if(!member.getPwd().equals(pwd))
			return "redirect:login?error";

		session.setAttribute("username", member.getUsername());

		if(returnURL != null && !returnURL.equals(""))
			return "redirect:"+returnURL;

        return "redirect:/index";
	}
}

