package com.xzymon.hpersest.jsf.converters;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;

import org.hibernate.Session;

import com.xzymon.hpersest.model.Category;

@Model
public class CategoryConverter implements Converter {
	
	@Inject
	private Session session;

	public CategoryConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext facesCtx, UIComponent component, String submittedValue) {
		if(submittedValue==null || submittedValue.isEmpty()){
			return null;
		}
		Category result = null;
		
		try{
			Long id = Long.valueOf(submittedValue);
			session.beginTransaction();
			result = (Category) session.get(Category.class, id);
			session.getTransaction().commit();
		} catch(NumberFormatException numberEx){
			throw new ConverterException(new FacesMessage(String.format("Passed value is not a Category id: %s", submittedValue)), numberEx);
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext facesCtx, UIComponent component, Object modelValue) {
		if(modelValue == null){
			return "";
		}
		
		if(modelValue instanceof Category){
			return String.valueOf(((Category)modelValue).getId());
		} else {
			throw new ConverterException(new FacesMessage(String.format("Passed value is not a Category object: %s", modelValue)));
		}
	}

}
