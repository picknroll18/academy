package com.newlecture.web.academy.dao.hb;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.academy.dao.MainMenuDao;
import com.newlecture.web.academy.entity.MainMenu;

@Repository
public class HbMainMenuDao implements MainMenuDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int insert(MainMenu mainMenu) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(mainMenu);
		
		if(id != null)
			return 1;
		
		return 0;
	}

	@Override
	public int update(MainMenu mainMenu) {

		Session session = sessionFactory.getCurrentSession();
		
		session.update(mainMenu);
		return 1;
	}

	@Override
	public int delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		MainMenu mainMenu = new MainMenu();
		mainMenu.setId(id);
		
		session.remove(mainMenu);
		
		return 1;
	}

	@Override
	@Transactional
	public MainMenu get(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		MainMenu mainMenu = session.get(MainMenu.class, id);
		
		return mainMenu;
	}

	@Override
	@Transactional
	public List<MainMenu> getList() {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MainMenu";
		List<MainMenu> list = session
							.createQuery(hql, MainMenu.class)	//SQL이 아니라 HQL이다. 주의!!
							.getResultList();
		
		return list;
	}

	@Override
	@Transactional
	public int deleteList(Integer[] menuIds) {	//null이 가능한 정수는 int가 아닌 Integer로 설정
		
		Session session = sessionFactory.getCurrentSession();
		
		//where, order by, having 등이 들어가면 쿼리 생성에서 문제가 발생
		//하나만 지우는게 아니라 여러개를 한번에 지우는거니까
		//id가 1이거나 2이거나 3이거나 삭제하는 코드
		String sql = "delete from MainMenu where id in (:ids)";
		
		Query query = session.createQuery(sql)
				.setParameterList("ids", menuIds);
		
		int result = query.executeUpdate();
		
		return result;
	}

	

	

}
