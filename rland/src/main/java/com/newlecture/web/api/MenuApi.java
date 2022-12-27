package com.newlecture.web.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;

// /api/menus/cate/2
@RestController
@RequestMapping("/api")
public class MenuApi {
	
	@Autowired
	private MenuService service;
	
	@GetMapping("/menus")
	public List<Menu> list(@RequestParam("c") int category) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Menu> list = service.getListByCategory(category);
		return list;
	}
	
	
	@GetMapping("/menus/{id}")
	public String item(@PathVariable("id") int id) {
		return "";
	}

	@DeleteMapping("/menus/{id}")
	// @GetMapping("/delete")
	public Map<String, Object> delete(@PathVariable("id") int id){
		int result = service.delete(id);
		Map<String, Object> dto = new HashMap<>();
		dto.put("status", 200);
		dto.put("resultObject", result);

		return dto;
	}

	@PutMapping("/menus")
	// @PostMapping("/menus/reg")
	public Map<String, Object> reg(MultipartFile img, String name, int price, HttpServletRequest request) throws Exception{

		// System.out.println(name);
		// service.add(Menu);
		// service.getLastOne();

		Menu menu = service.getLastOneAfterAdding(name, img.getOriginalFilename(), price);

		Map<String, Object> dto = new HashMap<>();
		dto.put("status", 200);
		dto.put("resultObject", menu);


		// service.add(title, img.getOriginalFilename(), price);

		if(!img.isEmpty()){
			String path = "/image/product";
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
		return dto;
	}
}
