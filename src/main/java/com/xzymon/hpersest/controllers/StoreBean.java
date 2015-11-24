package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Store;
import com.xzymon.hpersest.util.Outcomes;

@RequestScoped
@Named
public class StoreBean {
	@Inject
	private Session session;
	
	@Inject
	private Logger logger;
	
	private Store modelBean;
	
	public StoreBean() {
		this.modelBean = new Store("", "", "", "");
	}
	
	public List<Store> getAll(){
		logger.debug("method getAll");
		session.beginTransaction();
		List<Store> result = (List<Store>) session.createCriteria(Store.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	public Store getModelBean(){
		logger.debug("method getModelBean");
		logger.debug(modelBean.toString());
		return modelBean;
	}
	
	public String create(){
		logger.debug("method create");
		session.beginTransaction();
		session.persist(this.modelBean);
		logger.debug("method create: modelBean has id=" + this.modelBean.getId());
		session.getTransaction().commit();
		logger.debug("method create: modelBean created, transaction commited");
		return Outcomes.STORES;
	}
	
	public String delete(Store store){
		logger.debug("method delete: before beginTransaction");
		session.beginTransaction();
		session.delete(store);
		session.getTransaction().commit();
		logger.debug("method delete: after commit");
		return Outcomes.STORES;
	}
	
	public String gotoUpdate(Store store){
		logger.debug("method gotoUpdate");
		this.modelBean = store;
		return Outcomes.UPDATE_STORE;
	}
	
	public String update(){
		logger.debug("method update: before beginTransaction");
		session.beginTransaction();
		logger.debug("method update: transaction began");
		Store toUpdate = (Store) session.get(Store.class, modelBean.getId());
		logger.debug("method update: after database get");
		toUpdate.setName(modelBean.getName());
		toUpdate.setCity(modelBean.getCity());
		toUpdate.setStreet(modelBean.getStreet());
		toUpdate.setNumber(modelBean.getNumber());
		logger.debug("method update: about to saveOrUpdate");
		session.saveOrUpdate(toUpdate);
		logger.debug("method update: about to commit transaction");
		session.getTransaction().commit();
		logger.debug("method update: after transaction commit");
		return Outcomes.STORES;
	}
	
	@PreDestroy
	public void closeSession(){
		logger.debug("method closeSession");
		session.close();
		logger.debug("method closeSession: session closed");
	}
}
