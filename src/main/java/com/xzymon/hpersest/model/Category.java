package com.xzymon.hpersest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kategorie")
public class Category {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_kategorii")
	private Long id;
	@Column(name="nazwa")
	private String name;
	@Column(name="kod")
	private String code;
	
	public Category(){
		
	}
	
	public Category(String name, String code){
		this.name = name;
		this.code = code;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
