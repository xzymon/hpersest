package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;

import com.xzymon.hpersest.model.Store;

@RequestScoped
@Named
public class StoreBean {
	@Inject
	private Session session;
	
	private Store store;
	
	public StoreBean() {
		this.store = new Store();
	}
	
	public List<Store> getStores(){
		session.beginTransaction();
		List<Store> result = (List<Store>) session.createCriteria(Store.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	public Store getStore(){
		return store;
	}
	
	public String createStore(){
		session.beginTransaction();
		session.persist(this.store);
		session.getTransaction().commit();
		return "stores";
	}
	
	public String deleteStore(Store store){
		session.beginTransaction();
		session.delete(store);
		session.getTransaction().commit();
		return "stores";
	}
	
	public String gotoUpdateStore(Store store){
		this.store = store;
		return "stores-create";
	}
	
	public String updateStore(){
		session.beginTransaction();
		session.update(store);
		session.getTransaction().commit();
		return "stores";
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
