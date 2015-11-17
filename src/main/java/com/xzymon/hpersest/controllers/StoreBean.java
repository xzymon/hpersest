package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.Store;

@RequestScoped
@Named
public class StoreBean {
	@Inject
	private Session session;
	
	@Inject
	private Logger logger;
	
	private Store store;
	
	public StoreBean() {
		this.store = new Store();
	}
	
	public List<Store> getStores(){
		logger.info("method getStores");
		session.beginTransaction();
		List<Store> result = (List<Store>) session.createCriteria(Store.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	public Store getStore(){
		logger.info("method getStore");
		logger.info(store.toString());
		return store;
	}
	
	public String createStore(){
		logger.info("method createStore");
		session.beginTransaction();
		session.persist(this.store);
		session.getTransaction().commit();
		return "stores";
	}
	
	public String deleteStore(Store store){
		logger.info("method deleteStore: before beginTransaction");
		session.beginTransaction();
		session.delete(store);
		session.getTransaction().commit();
		logger.info("method deleteStore: after commit");
		return "stores";
	}
	
	public String gotoUpdateStore(Store store){
		logger.info("method gotoUpdateStore");
		this.store = store;
		return "stores-create";
	}
	
	public String updateStore(){
		logger.info("method updateStore: before beginTransaction");
		session.beginTransaction();
		logger.info("method updateStore: transaction began");
		Store toUpdate = new Store();
		toUpdate.setId(store.getId());
		toUpdate.setName(store.getName());
		toUpdate.setCity(store.getCity());
		toUpdate.setStreet(store.getStreet());
		toUpdate.setNumber(store.getNumber());
		logger.info("method updateStore: about to saveOrUpdate");
		session.saveOrUpdate(toUpdate);
		logger.info("method updateStore: about to commit transaction");
		session.getTransaction().commit();
		logger.info("method updateStore: after transaction commit");
		return "stores";
	}
	
	@PreDestroy
	public void closeSession(){
		logger.info("method closeSession");
		session.close();
		logger.info("method closeSession: session closed");
	}
}
