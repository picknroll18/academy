package com.newlecture.web.academy.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.academy.entity.MainMenu;
import com.newlecture.web.academy.service.ViewMngService;

@Controller
@RequestMapping("/sist/admin/view/")
public class ViewController {

	@Autowired
	private ViewMngService service;
	//물리 아키텍쳐를 만들어 놓고 거기에 구현을 한다??
	//서비스는 시스템을 기반으로 해야한다.
	//업무시스템>체계>업무절차
	//업무=행위 > 행위에 따른 역할자
	
	@GetMapping("header/menu-list")
	public String headerMenuList(
				@RequestParam(name="s", required=false) Integer selectedMenuId,/*int와 다르게 null값이 들어갈수 있기때문에 Integer로 선언*/
				Model model) {
		
		if(selectedMenuId != null) {
			//int menuId = Integer.parseInt(selectedMenuId);
			MainMenu selectedMenu = service.getMainMenu(selectedMenuId);
			model.addAttribute("selectedMenu", selectedMenu);
		}
			
		
		List<MainMenu> menus = service.getMainMenuList();
		model.addAttribute("menus", menus);
		
		return "admin.view.header.menu-list";
	}
	
	//버튼
	@PostMapping("header/menu-list")
	public String headerMenuList(
			MainMenu mainMenu,
			@RequestParam(defaultValue="") String action,
			@RequestParam("selected-menu-id") Integer selectedMenuId,
			@RequestParam(name="menu-id", required=false) Integer[] menuIds) {
		//input 에서 받아올 키값(name)이 "menu-id"다.
		//required=false => menu-id는 반드시 들어가야 하는 값은 아니다.
		
//		for(String id : menuIds)
//			System.out.println(id);
		mainMenu.setAcademyId("1"); //임의(1)로 설정, db에서 id 값을 자동증가하도록 설정하면 된다.
		switch(action) {
		case "일괄삭제":
			service.deleteMainMenuList(menuIds);
			break;
		case "수정":
			return "redirect:menu-list?s="+selectedMenuId;
		case "저장":
			mainMenu.setId(selectedMenuId);
			service.updateMainMenu(mainMenu);
			break;
		case "추가":
			service.addMainMenu(mainMenu);
			break;
		}
		
		return "redirect:menu-list";
	}
	
	
}





