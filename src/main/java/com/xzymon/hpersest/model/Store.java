package com.xzymon.hpersest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sklepy")
public class Store {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_sklepu")
	private Long id;
	@Column(name="nazwa", nullable=false, length=80)
	private String name;
	@Column(name="adres_miasto", nullable=true, length=50)
	private String city;
	@Column(name="adres_ulica", nullable=true, length=50)
	private String street;
	@Column(name="adres_nr", nullable=true, length=10)
	private String number;
	
	public Store() {
		// TODO Auto-generated constructor stub
	}

	public Store(String name, String city, String street, String number) {
		this.name = name;
		this.city = city;
		this.street = street;
		this.number = number;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", city=" + city + ", street=" + street + ", number=" + number
				+ "]";
	}
	
	
}
