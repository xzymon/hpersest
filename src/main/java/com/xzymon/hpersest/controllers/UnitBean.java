package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Category;
import com.xzymon.hpersest.model.Unit;

@Model
public class UnitBean {
	@Inject
	private Session session;
	
	@Inject
	private Logger logger;
	
	private Unit modelBean;
	
	public UnitBean() {
		this.modelBean = new Unit("", "", 1);
	}

	public List<Category> getAll(){
		session.beginTransaction();
		List<Category> result = (List<Category>) session.createCriteria(Unit.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	public Unit getModelBean(){
		return this.modelBean;
	}
	
	public String create(){
		session.beginTransaction();
		session.save(this.modelBean);
		session.getTransaction().commit();
		return "units";
	}
	
	public String delete(Unit unit){
		session.beginTransaction();
		session.delete(unit);
		session.getTransaction().commit();
		return "units";
	}
	
	public String gotoUpdate(Unit unit){
		this.modelBean = unit;
		return "unit-update";
	}
	
	public String update(){
		logger.debug("method update: about to begin transaction");
		session.beginTransaction();
		logger.debug("method update: transaction began");
		Unit toUpdate = (Unit) session.get(Unit.class, this.modelBean.getId());
		logger.debug("method update: after database get");
		toUpdate.setCode(modelBean.getCode());
		toUpdate.setName(modelBean.getName());
		toUpdate.setQuantityDenominator(modelBean.getQuantityDenominator());
		logger.debug("method update: about to saveOrUpdate");
		session.saveOrUpdate(toUpdate);
		logger.debug("method update: about to commit transaction");
		session.getTransaction().commit();
		logger.debug("method update: transaction commited");
		return "units";
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
