package com.xzymon.hpersest.controllers;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.xzymon.hpersest.model.MockConsumption;
import com.xzymon.hpersest.util.Outcomes;

@Model
public class MockConsumedBean {

	@Inject
	private Session session;
	
	@Inject
	private Logger logger;

	private MockConsumption modelBean;
	
	public MockConsumedBean() {
		this.modelBean = new MockConsumption();
	}

	public List<MockConsumption> getAll(){
		session.beginTransaction();
		List<MockConsumption> results = (List<MockConsumption>)session.createCriteria(MockConsumption.class).list();
		session.getTransaction().commit();
		return results;
	}
	
	public String create(){
		session.beginTransaction();
		session.persist(modelBean);
		session.getTransaction().commit();
		return Outcomes.MOCK;
	}
	
	public String delete(MockConsumption toDelete){
		session.beginTransaction();
		session.delete(toDelete);
		session.getTransaction().commit();
		return Outcomes.MOCK;
	}
	
	public String gotoUpdate(MockConsumption modelBean){
		this.modelBean = modelBean;
		return Outcomes.UPDATE_MOCK;
	}
	
	public String update(){
		session.beginTransaction();
		MockConsumption toUpdate = (MockConsumption) session.get(MockConsumption.class, modelBean.getId());
		if(toUpdate!=null){
			toUpdate.setProduct(modelBean.getProduct());
			toUpdate.setPrice(modelBean.getPrice());
			toUpdate.setConsumedNumerator(modelBean.getConsumedNumerator());
			toUpdate.setConsumedDenominator(modelBean.getConsumedDenominator());
			toUpdate.setDate(modelBean.getDate());
			toUpdate.setComment(modelBean.getComment());
			session.update(toUpdate);
		}
		session.getTransaction().commit();
		return Outcomes.MOCK;
	}
	
	public MockConsumption getModelBean(){
		return modelBean;
	}
	
	@PreDestroy
	public void closeSession(){
		session.close();
	}
}
