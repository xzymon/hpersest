package com.xzymon.hpersest.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Consumption {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="id_konsumpcji_realnej")
	private Long id;
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_zakupu", nullable=false, updatable=true)
	private Purchase purchase;
	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date date;
	@Column(name="licznik_skonsumowanej_czesci")
	private Integer consumedNumerator;
	@Column(name="mianownik_skonsumowanej_czesci")
	private Integer consumedDenominator;
	@Column(name="uwagi")
	private String comment;

	public Consumption() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Double getConsumedPart(){
		return ((double)consumedNumerator)/((double)consumedDenominator);
	}

	@Override
	public String toString() {
		return "Consumption [id=" + id + ", date=" + date + ", consumedNumerator=" + consumedNumerator
				+ ", consumedDenominator=" + consumedDenominator + ", comment=" + comment + "]";
	}

}
