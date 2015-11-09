package com.xzymon.hpersest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jednostki_produktu")
public class Unit {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_jednostki")
	private Long id;
	@Column(name="nazwa")
	private String name;
	@Column(name="kod")
	private String code;
	@Column(name="ilosc_ulamk_mianownik")
	private Integer quantityDenominator;
	
	public Unit(){
		
	}
	
	public Unit(String name, String code, Integer quantityDenominator){
		this.name = name;
		this.code = code;
		this.quantityDenominator = quantityDenominator;
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

	public Integer getQuantityDenominator() {
		return quantityDenominator;
	}

	public void setQuantityDenominator(Integer quantityDenominator) {
		this.quantityDenominator = quantityDenominator;
	}

	public Long getId() {
		return id;
	}
	
}
