package com.ong.springswagger.models;
import javax.persistence.*;

@Entity
public class PaymentAccount {
	
	@Id
	@GeneratedValue
	private Long id;
	private String user_id;
	private double balance;
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
