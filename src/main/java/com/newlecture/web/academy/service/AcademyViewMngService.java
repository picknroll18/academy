package com.newlecture.web.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.academy.dao.MainMenuDao;
import com.newlecture.web.academy.entity.MainMenu;

@Service
public class AcademyViewMngService implements ViewMngService {

	@Autowired
	public MainMenuDao mainMenuDao;
	
	@Override
	public List<MainMenu> getMainMenuList(){
		
		return mainMenuDao.getList();
	}
	

	@Override
	public int addMainMenu(MainMenu mainMenu) {
		
		int result = mainMenuDao.insert(mainMenu); 
		
		return result;
	}


	@Override
	public MainMenu getMainMenu(int selectedMenuId) {
		
		MainMenu menu = mainMenuDao.get(selectedMenuId);
		
		return menu;
	}


	@Override
	@Transactional
	public int updateMainMenu(MainMenu mainMenu) {
		
		MainMenu curMenu = mainMenuDao.get(mainMenu.getId());
		curMenu.setTitle(mainMenu.getTitle());
		curMenu.setUrl(mainMenu.getUrl());
		
		return mainMenuDao.update(curMenu);
		
	}


	@Override
	public int deleteMainMenuList(Integer[] menuIds) {
		// TODO Auto-generated method stub
		/*
		 * 
			1. 여기서 반복문을 이용해서 Dao.delete 메서드를 호출
			for(int id : menuIds)
				mainMenuDao.delete(id);
				//ViewController 에서 String[] menuIds를 Integer[] menuIds 로 변경해야함
			2. Dao에 menuIds 배열을 통째로 넘겨서 Dao가 한번에 삭제하게 하는 방법 
		 */
		
		
		return mainMenuDao.deleteList(menuIds);
	}
	
	

}
