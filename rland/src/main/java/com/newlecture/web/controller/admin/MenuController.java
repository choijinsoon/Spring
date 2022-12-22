package com.newlecture.web.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller("adminMenuController")
@RequestMapping("/admin/menu")
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
			Model model,
//			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response) {

//		session.setAttribute("test", "hello");
		String value = URLEncoder.encode("hello cookie");
		Cookie cookie = new Cookie("ctest",value);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*30);
		response.addCookie(cookie);
	
		
//	   service.testTS();
		int countInCart = service.countOfMenuInCart(1);
		
		List<Menu> list = service.getList(page);
		model.addAttribute("list", list);
		model.addAttribute("countInCart", countInCart);

		return "admin/menu/list";
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
	public String detail() {
		
		return "menu/detail";
	}
	
	@GetMapping("{id}")
	public String detailById(@PathVariable("id") int id
//						@CookieValue("test") String cookieValue
//						HttpSession session
						) {

//		int memberId = 1;
//		int countInCart = service.countOfMenuInCart(memberId);
		Menu menu = service.get(id);
//		List<Menu> rcmdlist = service.getRcmdListByMenu(menuId);
//		List<Menu> newList = service.getNewList();
//		Object test = session.getAttribute("test");
//		System.out.println(test);
		
		return "menu/detail";
	}

	@PostMapping("/reg")
	public String reg(MultipartFile img, String title, int price, HttpServletRequest request) throws Exception{

		// service.add(title, img.getOriginalFilename(), price);

		if(!img.isEmpty()){
			String path = "/image/menu";
			String realPath = request.getServletContext().getRealPath(path);
			System.out.println(realPath);

			File pathFile = new File(realPath);
			if(!pathFile.exists())
				pathFile.mkdirs();

			String fullPath = realPath + File.separator +img.getOriginalFilename();

			InputStream fis = img.getInputStream();
			OutputStream fos = new FileOutputStream(fullPath);

			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf))>=0)
				fos.write(buf, 0, size);

				
			fis.close();
			fos.close();
			
		}
		return "redirect:list";
	}

}