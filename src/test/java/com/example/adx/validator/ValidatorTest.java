package com.example.adx.validator;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.adx.entity.AccountEntity;
import com.example.adx.entity.OrderEntity;
import com.example.adx.entity.ProductEntity;
import com.example.adx.entity.ServiceImplEntity;


@RunWith(SpringRunner.class)
public class ValidatorTest {
	
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	OrderEntity order;
	AccountEntity account; 
	ServiceImplEntity service; 
	ProductEntity product ;
	
	
	@Test
	public void isInvalidDate() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(2);
		Assert.assertFalse(ValidateOrder.validateOrderDate(tomorrow));
	}
	
	@Test
	public void isInvalidCustomerName() throws Exception {
		LocalDate today = LocalDate.now();

		order = new OrderEntity();
		order.setOrderId(1);
		order.setOrderDate(today);
		
		account = new AccountEntity();
		account.setAccountId(order.getOrderId());
		account.setAcctType("Residence");
		account.setCustAddress("100 Holly ln");
		account.setCustName("");
		
		service = new ServiceImplEntity();
		service.setServiceId(1000);
		service.setName("Internet");
		service.setProdDesc("Modem");
		List<ServiceImplEntity> serviceList = new ArrayList<>();
		
		product = new ProductEntity();
		product.setPid(1);
		product.setDescription("NetGear 300");
		product.setRate(50);
		List<ProductEntity> productList = new ArrayList<>();
		productList.add(product);
		
		service.setProductList(productList);
		serviceList.add(service);
		
		account.setService(serviceList);
		
		ee.expect(Exception.class);
//		ee.expectMessage();
//		ee.expectMessage("ValidateOrder.INVALID_CUSTOMER_NAME");
		ValidateOrder.validateOrder(order);
		
	}
	
	@Test
	public void isInvalidAccountType() throws Exception {
		LocalDate today = LocalDate.now();

		order = new OrderEntity();
		order.setOrderId(1);
		order.setOrderDate(today);
		
		account = new AccountEntity();
		account.setAccountId(order.getOrderId());
		account.setAcctType("");
		account.setCustAddress("100 Holly ln");
		account.setCustName("Jacob");
		
		service = new ServiceImplEntity();
		service.setServiceId(1000);
		service.setName("Internet");
		service.setProdDesc("Modem");
		List<ServiceImplEntity> serviceList = new ArrayList<>();
		
		product = new ProductEntity();
		product.setPid(1);
		product.setDescription("NetGear 300");
		product.setRate(50);
		List<ProductEntity> productList = new ArrayList<>();
		productList.add(product);
		
		service.setProductList(productList);
		serviceList.add(service);
		
		account.setService(serviceList);
		
		ee.expect(Exception.class);
//		ee.expectMessage();
		ValidateOrder.validateOrder(order);
		
	}
	
	@Test
	public void isInvalidCustomerAddress() throws Exception {
		LocalDate today = LocalDate.now();

		order = new OrderEntity();
		order.setOrderId(1);
		order.setOrderDate(today);
		
		account = new AccountEntity();
		account.setAccountId(order.getOrderId());
		account.setAcctType("Resident");
		account.setCustAddress("");
		account.setCustName("Neron");
		
		service = new ServiceImplEntity();
		service.setServiceId(1000);
		service.setName("Internet");
		service.setProdDesc("Modem");
		List<ServiceImplEntity> serviceList = new ArrayList<>();
		
		product = new ProductEntity();
		product.setPid(1);
		product.setDescription("NetGear 300");
		product.setRate(50);
		List<ProductEntity> productList = new ArrayList<>();
		productList.add(product);
		
		service.setProductList(productList);
		serviceList.add(service);
		
		account.setService(serviceList);
		
		ee.expect(Exception.class);
//		ee.expectMessage();
		ValidateOrder.validateOrder(order);
		
	}
	
	

	
}
