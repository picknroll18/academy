package com.newlecture.web.academy.dao;

import java.util.List;

import com.newlecture.web.academy.entity.Academy;

public interface AcademyDao {
	
	public int insert(Academy academy);
	public int update(Academy academy);
	public int delete(String id);
	public Academy get(String id);
	public List<Academy> getList();

}
