package com.example.adx.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="service")
@GenericGenerator(name="idGen", strategy="increment")
public class ServiceImplEntity {

	@Id
	@Column(name="service_id")
	private Integer serviceId;
	@Column(name="service_name")
	private String name;
	
	@Column(name="product_description")
	private String prodDesc;

	@OneToMany
	@Column(name="product_id_list")
	private List<ProductEntity> productList;

	
	public List<ProductEntity> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductEntity> productList) {
		this.productList = productList;
	}

	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer Id) {
		this.serviceId = Id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getServiceAddress() {
//		return serviceAddress;
//	}
//	public void setServiceAddress(String serviceAddress) {
//		this.serviceAddress = serviceAddress;
//	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

}
