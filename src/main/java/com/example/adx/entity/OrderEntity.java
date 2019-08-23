package com.example.adx.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="orders")
@GenericGenerator(name="idGen", strategy="increment")
public class OrderEntity {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(generator="idGen")
	private Integer orderId;
	@Column(name="order_date")
	private LocalDate orderDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	private AccountEntity account;
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = LocalDate.now();
	}
	public AccountEntity getAccount() {
		return account;
	}
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
