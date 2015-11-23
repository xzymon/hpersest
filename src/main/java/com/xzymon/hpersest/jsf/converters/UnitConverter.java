package com.xzymon.hpersest.jsf.converters;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;

import org.hibernate.Session;

import com.xzymon.hpersest.model.Unit;

@Model
public class UnitConverter implements Converter {

	@Inject
	private Session session;
	
	public UnitConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext facesCtx, UIComponent component, String submittedValue) {
		if(submittedValue == null || submittedValue.isEmpty()){
			return null;
		}
		
		try{
			Long id = Long.valueOf(submittedValue);
			session.beginTransaction();
			Unit result = (Unit)session.get(Unit.class, id);
			session.getTransaction().commit();
			return result;
		} catch (NumberFormatException numberEx){
			throw new ConverterException(new FacesMessage(String.format("Passed value is not a Unit id: %s", submittedValue)), numberEx);
		}
	}

	@Override
	public String getAsString(FacesContext facesCtx, UIComponent component, Object modelValue) {
		if(modelValue == null){
			return "";
		}
		
		if(modelValue instanceof Unit){
			return String.valueOf(((Unit)modelValue).getId());
		} else {
			throw new ConverterException(new FacesMessage(String.format("Passed value is not a Unit: %s", modelValue)));
		}
	}

}
