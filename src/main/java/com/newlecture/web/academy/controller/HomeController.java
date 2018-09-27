package com.newlecture.web.academy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.academy.dao.MainMenuDao;
import com.newlecture.web.academy.entity.MainMenu;

@Controller("academyController")
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private MainMenuDao mainMenuDao;
	
	@GetMapping("index")
	public String index(Model model) {
		
		List<MainMenu> mainMenus = mainMenuDao.getList();

		model.addAttribute("mainMenus", mainMenus);
		
		return "home.index";
	}
	
	@PostMapping("upload-ajax")
	@ResponseBody //view단이 필요 없는, javascript가 바로 찾을 수 있다
	public String uploadAjax(MultipartFile file
			/*, Principal principal*/
			,HttpServletRequest request) {	//servletcontext에 multipartfile이 구현되있는지 확인 필요
		
		//newlecture의 member가 academy 소속인지 확인
//		String memberId = principal.getName();
		
		String academyId = "sist"; //service.getAcademyIdByMemberId(memberId); 
		
		// 파일 넣을 경로: /academy/resources/partners/sist/
		String urlPath = "/resources/partners/" + academyId;
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath(urlPath);
		
		File uploadedFile = new File(realPath);
		
		if(!uploadedFile.exists()) 
			uploadedFile.mkdirs();
		
		//파일 복사
		InputStream fis;
		
		try {
			fis = file.getInputStream();

			FileOutputStream fos = new FileOutputStream(uploadedFile);
			
			byte[] buf = new byte[1024];
			
			int size = 0;
			while((size = fis.read(buf)) >= 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return "";
	}
}