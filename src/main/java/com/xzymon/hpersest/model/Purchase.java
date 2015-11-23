package com.xzymon.hpersest.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Purchase {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_zakupu")
	private Long id;
	
	
	private Product product;
	private Store store;
	@Column(name="cena_calk")
	private Integer intPrice;
	@Column(name="cena_ulamk")
	private Short partPrice;
	@Column(name="uwagi")
	private String comment;
	@Column(name="data")
	private Date date;
	@Column(name="ilosc_calk")
	private Integer intQuantity;
	@Column(name="ilosc_ulamk")
	private Short partQuantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Integer getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(Integer intPrice) {
		this.intPrice = intPrice;
	}
	public Short getPartPrice() {
		return partPrice;
	}
	public void setPartPrice(Short partPrice) {
		this.partPrice = partPrice;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getIntQuantity() {
		return intQuantity;
	}
	public void setIntQuantity(Integer intQuantity) {
		this.intQuantity = intQuantity;
	}
	public Short getPartQuantity() {
		return partQuantity;
	}
	public void setPartQuantity(Short partQuantity) {
		this.partQuantity = partQuantity;
	}
	
	
}
