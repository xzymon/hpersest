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
	
	public StoreBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Store> getStores(){
		session.beginTransaction();
		List<Store> result = (List<Store>) session.createCriteria(Store.class).list();
		session.getTransaction().commit();
		return result;
	}

	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
