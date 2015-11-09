package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;

import com.xzymon.hpersest.model.Category;

@Model
public class CategoryBean {
	@Inject
	private Session session;
	
	public CategoryBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Category> getCategories(){
		session.beginTransaction();
		List<Category> result = (List<Category>) session.createCriteria(Category.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
