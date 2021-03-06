package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Product;
import com.xzymon.hpersest.util.Outcomes;

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
		return Outcomes.PRODUCTS;
	}
	
	public String delete(Product toDelete){
		session.beginTransaction();
		session.delete(toDelete);
		session.getTransaction().commit();
		return Outcomes.PRODUCTS;
	}
	
	public String gotoUpdate(Product modelBean){
		this.modelBean = modelBean;
		return Outcomes.UPDATE_PRODUCT;
	}
	
	public String update(){
		session.beginTransaction();
		Product toUpdate = (Product) session.get(Product.class, modelBean.getId());
		if(toUpdate!=null){
			toUpdate.setName(modelBean.getName());
			toUpdate.setCategory(modelBean.getCategory());
			toUpdate.setUnit(modelBean.getUnit());
			session.update(toUpdate);
		}
		session.getTransaction().commit();
		return Outcomes.PRODUCTS;
	}
	
	public Product getModelBean(){
		return modelBean;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
