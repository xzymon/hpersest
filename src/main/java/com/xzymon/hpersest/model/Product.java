package com.xzymon.hpersest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produkty")
public class Product {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_produkt")
	private Long id;
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_kategorii", nullable=false, updatable=false)
	private Category category;
	@Column(name="nazwa", nullable=false, length=255)
	private String name;
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_jednostki", nullable=false, updatable=false)
	private Unit unit;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	
}
