package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;

import com.xzymon.hpersest.model.Unit;

@Model
public class UnitBean {
	@Inject
	private Session session;

	public UnitBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Unit> getUnits(){
		session.beginTransaction();
		List<Unit> result = (List<Unit>)session.createCriteria(Unit.class).list();
		session.getTransaction().commit();
		return result;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
