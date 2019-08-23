package com.example.adx.repository;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.adx.entity.AccountEntity;
import com.example.adx.entity.OrderEntity;
import com.example.adx.entity.ProductEntity;
import com.example.adx.entity.ServiceImplEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional
public class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	private OrderEntity order1, order2;
	private AccountEntity acc1, acc2;
	private ServiceImplEntity srv1, srv2;
	private ProductEntity p1, p2;
	
	public void order1() {
		order1 = new OrderEntity();
		order1.setOrderId(1);
		LocalDate today = LocalDate.now();
		order1.setOrderDate(today);
		
		acc1 = new AccountEntity();
		acc1.setAccountId(1);
		acc1.setAcctType("Resident");
		acc1.setCustAddress("1000 Address ln");
		acc1.setCustName("Peter");
		
		srv1 = new ServiceImplEntity();
		srv1.setServiceId(1000);
		srv1.setName("Phone");
		srv1.setProdDesc("Bundle");
		List<ServiceImplEntity> sList = new ArrayList<>();
		//sList.add(srv1);
		
		p1 = new ProductEntity();
		p1.setPid(1);
		p1.setDescription("Phone");
		p1.setRate(100);
		List<ProductEntity> pList = new ArrayList<>();
		
		srv1.setProductList(pList);
		sList.add(srv1);
		acc1.setService(sList);
		order1.setAccount(acc1);
	}
	
	public void order2() {
		order2 = new OrderEntity();
		order2.setOrderId(2);
		LocalDate today = LocalDate.now();
		order2.setOrderDate(today);
		
		acc2 = new AccountEntity();
		acc2.setAccountId(2);
		acc2.setAcctType("Resident");
		acc2.setCustAddress("1000 Address ln");
		acc2.setCustName("Peter");
		
		srv2 = new ServiceImplEntity();
		srv2.setServiceId(1000);
		srv2.setName("Phone");
		srv2.setProdDesc("Bundle");
		List<ServiceImplEntity> sList = new ArrayList<>();
		//sList.add(srv1);
		
		p2 = new ProductEntity();
		p2.setPid(1);
		p2.setDescription("Phone");
		p2.setRate(100);
		List<ProductEntity> pList = new ArrayList<>();
		
		srv2.setProductList(pList);
		sList.add(srv2);
		acc2.setService(sList);
		order2.setAccount(acc2);
	}
	
	@Before
	public void setup() {
		order1();
		order2();
	}
	
	@Test
	public void createOrder() {
		OrderEntity orderE = new OrderEntity();
		orderE.setOrderDate(order1.getOrderDate());
		
		AccountEntity acc = new AccountEntity();
		acc.setAcctType(acc1.getAcctType());
		acc.setCustAddress(acc1.getCustAddress());
		acc.setCustName(acc1.getCustName());
		
		ServiceImplEntity srv = new ServiceImplEntity();
		srv.setServiceId(srv1.getServiceId());
		srv.setName(srv1.getName());
		srv.setProdDesc(srv1.getProdDesc());
		List<ServiceImplEntity> seList = new ArrayList<>();
		
		ProductEntity pe1 = new ProductEntity();
		pe1.setPid(p1.getPid());
		pe1.setDescription(p1.getDescription());
		pe1.setRate(p1.getRate());
		List<ProductEntity> peList = new ArrayList<>();
		
		srv.setProductList(peList);
		seList.add(srv);
		acc.setService(seList);
		orderE.setAccount(acc);

		OrderEntity o = orderRepository.save(orderE);
		assertThat(o).hasFieldOrPropertyWithValue("orderId", orderE.getOrderId()).isNotNull();
		
	}
	
	
	@Test
	public void getOneOrder() {
		Assert.assertNotNull(orderRepository.getOne(order1.getOrderId()));
	}
	
	@Test
	public void getAllOrder() {
		List<OrderEntity> orderList = orderRepository.findAll();
		assertThat(orderList.size()).isGreaterThanOrEqualTo(0);
	}
	
	@Test
	public void deleteOrder() throws Exception {
		
		ee.expect(Exception.class);
		ee.expectMessage("No class com.example.adx.entity.OrderEntity entity with id 1 exists!");
		orderRepository.deleteById(order1.getOrderId());
       // Assert.assertNull(orderRepository.findById(order1.getOrderId()));
	}
	
	
}
