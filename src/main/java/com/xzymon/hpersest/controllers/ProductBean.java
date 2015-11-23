package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Product;

@Model
public class ProductBean {
	@Inject
	private Session session;
	
	@Inject
	private Logger logger;

	private Product modelBean;
	
	public ProductBean() {
		this.modelBean = new Product();
	}

	public List<Product> getAll(){
		session.beginTransaction();
		List<Product> results = (List<Product>)session.createCriteria(Product.class).list();
		session.getTransaction().commit();
		return results;
	}
	
	public String create(){
		session.beginTransaction();
		session.persist(modelBean);
		session.getTransaction().commit();
		return "products";
	}
	
	public Product getModelBean(){
		return modelBean;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
