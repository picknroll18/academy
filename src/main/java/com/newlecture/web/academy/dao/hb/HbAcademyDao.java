package com.newlecture.web.academy.dao.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.academy.dao.AcademyDao;
import com.newlecture.web.academy.entity.Academy;

@Repository
public class HbAcademyDao implements AcademyDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insert(Academy academy) {
		Session session = sessionFactory.getCurrentSession();
		Object id = session.save(academy);
		if(id != null)
			return 1;
		return 0;
	}

	@Override
	public int update(Academy academy) {
		Session session = sessionFactory.getCurrentSession();
		session.update(academy);
		return 1;
	}

	@Override
	public int delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Academy academy = new Academy();
		academy.setId(id);
		session.remove(academy);
		return 1;
	}

	@Override
	public Academy get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Academy academy = session.get(Academy.class, id);
		return academy;
	}

	@Override
	public List<Academy> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Academy";
		List<Academy> list = session
							.createQuery(hql, Academy.class)	//SQL이 아니라 HQL이다. 주의!!
							.getResultList();
		return list;
	}

}