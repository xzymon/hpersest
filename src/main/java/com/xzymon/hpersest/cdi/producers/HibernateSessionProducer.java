package com.xzymon.hpersest.cdi.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xzymon.hpersest.util.AppConstants;


public class HibernateSessionProducer {

	//@Inject
	//private FacesContext facesContext;
	
	@Inject
	private ServletContext servletCtx;
	
	@Produces
	@RequestScoped
	public Session produceHibernateSession(){
		//Map<String, Object> servletContextMap = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
		//SessionFactory factory = (SessionFactory) servletContextMap.get(AppConstants.HIBERNATE_SESSION_FACTORY_ATTR_NAME);
		//return factory.openSession();
		
		SessionFactory factory = (SessionFactory) servletCtx.getAttribute(AppConstants.HIBERNATE_SESSION_FACTORY_ATTR_NAME);
		return factory.openSession();
	}
}