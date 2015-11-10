package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;

import com.xzymon.hpersest.model.Category;

@RequestScoped
@Named
public class CategoryBean {
	@Inject
	private Session session;
	
	private Category category;
	
	public CategoryBean() {
		this.category = new Category();
	}

	public List<Category> getCategories(){
		session.beginTransaction();
		List<Category> result = (List<Category>) session.createCriteria(Category.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	public Category getCategory(){
		return this.category;
	}
	
	public String createCategory(){
		session.beginTransaction();
		session.save(this.category);
		session.getTransaction().commit();
		return "categories";
	}
	
	public String deleteCategory(Category category){
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
		return "categories";
	}
	
	public String gotoUpdateCategory(Category category){
		this.category = category;
		return "categories-create";
	}
	
	public String updateCategory(){
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
		return "categories";
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
