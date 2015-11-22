package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Category;

@RequestScoped
@Named
public class CategoryBean {
	@Inject
	private Session session;
	
	@Inject
	private Logger logger;
	
	private Category modelBean;
	
	public CategoryBean() {
		this.modelBean = new Category("", "");
	}

	public List<Category> getAll(){
		session.beginTransaction();
		List<Category> result = (List<Category>) session.createCriteria(Category.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	public Category getModelBean(){
		return this.modelBean;
	}
	
	public String create(){
		session.beginTransaction();
		session.save(this.modelBean);
		session.getTransaction().commit();
		return "categories";
	}
	
	public String delete(Category category){
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
		return "categories";
	}
	
	public String gotoUpdate(Category category){
		this.modelBean = category;
		return "category-update";
	}
	
	public String update(){
		logger.debug("method update: about to begin transaction");
		session.beginTransaction();
		logger.debug("method update: transaction began");
		Category toUpdate = (Category) session.get(Category.class, this.modelBean.getId());
		logger.debug("method update: after database get");
		toUpdate.setCode(modelBean.getCode());
		toUpdate.setName(modelBean.getName());
		logger.debug("method update: about to saveOrUpdate");
		session.saveOrUpdate(toUpdate);
		logger.debug("method update: about to commit transaction");
		session.getTransaction().commit();
		logger.debug("method update: transaction commited");
		return "categories";
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
