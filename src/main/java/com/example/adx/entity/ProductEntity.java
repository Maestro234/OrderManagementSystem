package com.example.adx.entity;

import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
public class ProductEntity {

	@Id
	private Integer pid;
	private String description;
	private Integer rate;

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	
}
