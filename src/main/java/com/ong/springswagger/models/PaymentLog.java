package com.ong.springswagger.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PaymentLog {

	@Id
	@GeneratedValue
	private Long id;
	private String account_id;
	private String datetime;
	private long balance;
	private String purchase_id;
	


	public PaymentLog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getDatetime() {
		return datetime;
	}
 
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}

	public PaymentLog(Long id, String account_id, String datetime, long balance, String purchase_id) {
		super();
		this.id = id;
		this.account_id = account_id;
		this.datetime = datetime;
		this.balance = balance;
		this.purchase_id = purchase_id;
	}

}
