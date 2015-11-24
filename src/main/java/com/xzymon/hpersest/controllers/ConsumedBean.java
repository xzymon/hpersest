package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Consumption;
import com.xzymon.hpersest.util.Outcomes;

@Model
public class ConsumedBean {

	@Inject
	private Session session;
	
	@Inject
	private Logger logger;

	private Consumption modelBean;
	
	public ConsumedBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Consumption> getAll(){
		session.beginTransaction();
		List<Consumption> results = (List<Consumption>)session.createCriteria(Consumption.class).list();
		session.getTransaction().commit();
		return results;
	}
	
	public String create(){
		session.beginTransaction();
		session.persist(modelBean);
		session.getTransaction().commit();
		return Outcomes.CONSUMPTION;
	}
	
	public String delete(Consumption toDelete){
		session.beginTransaction();
		session.delete(toDelete);
		session.getTransaction().commit();
		return Outcomes.CONSUMPTION;
	}
	
	public String gotoUpdate(Consumption modelBean){
		this.modelBean = modelBean;
		return Outcomes.UPDATE_CONSUMPTION;
	}
	
	public String update(){
		session.beginTransaction();
		Consumption toUpdate = (Consumption) session.get(Consumption.class, modelBean.getId());
		if(toUpdate!=null){
			toUpdate.setPurchase(modelBean.getPurchase());
			toUpdate.setConsumedNumerator(modelBean.getConsumedNumerator());
			toUpdate.setConsumedDenominator(modelBean.getConsumedDenominator());
			toUpdate.setDate(modelBean.getDate());
			toUpdate.setComment(modelBean.getComment());
			session.update(toUpdate);
		}
		session.getTransaction().commit();
		return Outcomes.CONSUMPTION;
	}
	
	public Consumption getModelBean(){
		return modelBean;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
