package com.example.adx.entity;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="account")
@GenericGenerator(name="idGen", strategy="increment")
public class AccountEntity {

	@Id
	@Column(name="account_Id")
	@GeneratedValue(generator="idGen")
	private Integer accountId;
	@Column(name="account_type")
	private String acctType;
	@Column(name="customer_name")
	private String custName;
	@Column(name="customer_address")
	private String custAddress;
	
	@OneToMany
	@JoinTable(name="account_services",
	joinColumns=@JoinColumn(name="account_id", referencedColumnName="account_id"),
	inverseJoinColumns=@JoinColumn(name="service_id", referencedColumnName="service_id", unique=true))
	private List<ServiceImplEntity> service;


	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public List<ServiceImplEntity> getService() {
		return service;
	}

	public void setService(List<ServiceImplEntity> service) {
		this.service = service;
	}
	
	
}
