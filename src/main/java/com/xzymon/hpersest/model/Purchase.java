package com.xzymon.hpersest.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="zakupione_produkty")
public class Purchase {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_zakupu")
	private Long id;
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_produkt", nullable=false, updatable=true)
	private Product product;
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_sklepu", nullable=false, updatable=true)
	private Store store;
	@Column(name="cena")
	private BigDecimal price;
	@Column(name="uwagi")
	private String comment;
	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date date;
	@Column(name="ilosc")
	private BigDecimal quantity;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", price=" + price + ", comment=" + comment + ", date=" + date + ", quantity="
				+ quantity + "]";
	}
	
	public String getName(){
		return product.getName() + "[" + price + "]";
	}
}
