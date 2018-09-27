package com.newlecture.web.academy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class MainMenu {

	/*
	 	update MainMenu
	 	set id = ?
	 		title = ?
	 		url = ?
	 		academyId = ?
	 * */
	@Id
	@GeneratedValue (
		strategy=GenerationType.AUTO
		,generator="native" /*dbms의 자동증가 방식으로 설정하겠다=native, hibernate가 자동증가 시킨후에 db에 입력해줘라*/
	)/*mysql의 경우 default값이 자동으로 입력된다*/
	@GenericGenerator(
		name="native"
		,strategy="native"
	)
	private int id;
	private String title;
	private String url;
	@Column(updatable=false)	//update할때 넣지 않아도 되는 값으로 설정
	private int academyId;
	@Column(updatable=false)	//update할때 넣지 않아도 되는 값으로 설정
	private Integer parentId; //null이 들어갈수 있는 entity는 문자열이 들어갈 수 있는 정수형으로 바꿔줘야한다.
	@Column(insertable=false, name="[order]")
	private int order;
	
	public MainMenu() {
		
	}
	
	//for updating
	public MainMenu(int id, String title, String url) {
		this.id = id;
		this.title = title;
		this.url = url;
	}
	
	public MainMenu(String title, String url, int academyId) {
		this.title = title;
		this.url = url;
		this.academyId = academyId;
	}

	public MainMenu(int id, String title, String url, int academyId, Integer parentId, int order) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.academyId = academyId;
		this.parentId = parentId;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getAcademyId() {
		return academyId;
	}

	public void setAcademyId(int academyId) {
		this.academyId = academyId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	

	@Override
	public String toString() {
		return "MainMenu [id=" + id + ", title=" + title + ", url=" + url + ", academyId=" + academyId + ", parentId="
				+ parentId + ", order=" + order + "]";
	}

	
}
