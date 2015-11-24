package com.xzymon.hpersest.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class MockConsumption {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_konsumpcji_wirtualnej")
	private Long id;
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_produkt", nullable=false, updatable=true)
	private Product product;
	@Column(name="cena")
	private BigDecimal price;
	@Column(name="licznik_skonsumowanej_czesci")
	private Integer consumedNumerator;
	@Column(name="mianownik_skonsumowanej_czesci")
	private Integer consumedDenominator;
	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date date;
	@Column(name="uwagi")
	private String comment;

	public MockConsumption() {
		// TODO Auto-generated constructor stub
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getConsumedNumerator() {
		return consumedNumerator;
	}

	public void setConsumedNumerator(Integer consumedNumerator) {
		this.consumedNumerator = consumedNumerator;
	}

	public Integer getConsumedDenominator() {
		return consumedDenominator;
	}

	public void setConsumedDenominator(Integer consumedDenominator) {
		this.consumedDenominator = consumedDenominator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Double getConsumedPart(){
		return ((double)consumedNumerator/(double)consumedDenominator);
	}

	@Override
	public String toString() {
		return "MockConsumption [id=" + id + ", price=" + price + ", consumedNumerator=" + consumedNumerator
				+ ", consumedDenominator=" + consumedDenominator + ", date=" + date + ", comment=" + comment + "]";
	}
}
