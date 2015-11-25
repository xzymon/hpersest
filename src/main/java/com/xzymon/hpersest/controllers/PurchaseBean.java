package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Purchase;
import com.xzymon.hpersest.util.Outcomes;

@Model
public class PurchaseBean {

	@Inject
	private Session session;
	
	@Inject
	private Logger logger;

	private Purchase modelBean;
	
	public PurchaseBean() {
		this.modelBean = new Purchase();
	}

	public List<Purchase> getAll(){
		session.beginTransaction();
		List<Purchase> results = (List<Purchase>)session.createCriteria(Purchase.class).list();
		session.getTransaction().commit();
		return results;
	}
	
	public String create(){
		session.beginTransaction();
		session.persist(modelBean);
		session.getTransaction().commit();
		return Outcomes.PURCHASES;
	}
	
	public String delete(Purchase toDelete){
		session.beginTransaction();
		session.delete(toDelete);
		session.getTransaction().commit();
		return Outcomes.PURCHASES;
	}
	
	public String gotoUpdate(Purchase modelBean){
		this.modelBean = modelBean;
		return Outcomes.UPDATE_PURCHASE;
	}
	
	public String update(){
		session.beginTransaction();
		Purchase toUpdate = (Purchase) session.get(Purchase.class, modelBean.getId());
		if(toUpdate!=null){
			toUpdate.setProduct(modelBean.getProduct());
			toUpdate.setStore(modelBean.getStore());
			toUpdate.setPrice(modelBean.getPrice());
			toUpdate.setQuantity(modelBean.getQuantity());
			toUpdate.setDate(modelBean.getDate());
			toUpdate.setComment(modelBean.getComment());
			session.update(toUpdate);
		}
		session.getTransaction().commit();
		return Outcomes.PURCHASES;
	}
	
	public Purchase getModelBean(){
		return modelBean;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
