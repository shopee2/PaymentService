package com.ong.springswagger.models;

import javax.persistence.*;

import java.util.ArrayList;

@Entity
public class PaymentAccount {

	@Id
	@GeneratedValue
	private Long id;
	private String user_id;
	private double balance;
	private ArrayList type;

	public PaymentAccount() {
		super();
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public ArrayList getType() {
		return type;
	}

	public void setType(ArrayList type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentAccount(Long id, String user_id, double balance) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.balance = balance;
	}

}
