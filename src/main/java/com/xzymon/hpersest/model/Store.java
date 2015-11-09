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
	@org.hibernate.annotations.GenericGenerator(
		name = "ID_GENERATOR", 
		strategy = "enhanced-sequence",
		parameters = {
			@org.hibernate.annotations.Parameter(name="sequence_name", value="XZYMON_SEQUENCE"),
			@org.hibernate.annotations.Parameter(name="initial_value", value="1000")
		}
	)
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

	public Long getId() {
		return id;
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
}
