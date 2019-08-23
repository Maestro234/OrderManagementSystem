package com.example.adx.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.adx.entity.AccountEntity;
import com.example.adx.entity.OrderEntity;
import com.example.adx.entity.ProductEntity;
import com.example.adx.entity.ServiceImplEntity;
import com.example.adx.repository.AccountRepository;
import com.example.adx.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	/*
	 * @Mock annotation creates a mock implementation for the class it is annotated
	 * with.
	 * 
	 * @InjectMocks also creates the mock implementation, additionally injects the
	 * dependent mocks that are marked with the annotations @Mock into it.
	 */

	@Autowired
	private OrderServiceImpl orderService;
	@MockBean
	private OrderRepository orderRepository;
	@MockBean
	private AccountRepository accountRepository;
	
	@Rule
	public ExpectedException ee = ExpectedException.none();

	
	@Test
	public void createOrder() throws Exception {
		LocalDate today = LocalDate.now();
		OrderEntity ordEntity = new OrderEntity();
		ordEntity.setOrderDate(today);

		AccountEntity accEntity = new AccountEntity();
		accEntity.setAcctType("Resident");
		accEntity.setCustAddress("100 Hello dr");
		accEntity.setCustName("Paul");

		ServiceImplEntity srvEntity = new ServiceImplEntity();
		srvEntity.setServiceId(100);
		srvEntity.setName("Voice");
		srvEntity.setProdDesc("4G LTE");
		List<ServiceImplEntity> seList = new ArrayList<>();
		
		ProductEntity pEntity = new ProductEntity();
		pEntity.setPid(1);
		pEntity.setDescription("iPhone");
		pEntity.setRate(900);
		List<ProductEntity> peList = new ArrayList<>();
		peList.add(pEntity);

		srvEntity.setProductList(peList);
		seList.add(srvEntity);

		accEntity.setService(seList);

		ordEntity.setAccount(accEntity);
		
		//if create order method in orderService calls the orderRepository.saveAndFlush
		//then return ordEntity
		Mockito.when(orderRepository.saveAndFlush(ordEntity)).thenReturn(ordEntity);
		assertThat(orderService.createOrder(ordEntity)).startsWith("Order");
	}

	@Test
	public void getOrderById() throws Exception {
		LocalDate today = LocalDate.now();
		OrderEntity ordEntity = new OrderEntity();
		ordEntity.setOrderDate(today);

		AccountEntity accEntity = new AccountEntity();
		accEntity.setAcctType("Resident");
		accEntity.setCustAddress("100 Hello dr");
		accEntity.setCustName("Paul");

		ServiceImplEntity srvEntity = new ServiceImplEntity();
		srvEntity.setServiceId(100);
		srvEntity.setName("Voice");
		srvEntity.setProdDesc("4G LTE");
		List<ServiceImplEntity> seList = new ArrayList<>();
		
		ProductEntity pEntity = new ProductEntity();
		pEntity.setPid(1);
		pEntity.setDescription("iPhone");
		pEntity.setRate(900);
		List<ProductEntity> peList = new ArrayList<>();
		peList.add(pEntity);

		srvEntity.setProductList(peList);
		seList.add(srvEntity);

		accEntity.setService(seList);

		ordEntity.setAccount(accEntity);
		
		//if get order method in orderService calls the orderRepository.findById
		//then return ordEntity
		Mockito.when(orderRepository.getOne(1)).thenReturn(ordEntity);
		assertThat(orderService.getorder(1)).isEqualTo(ordEntity);
	}
	
	@Test
	public void getAllOrders() {
		LocalDate today = LocalDate.now();
		OrderEntity ordEntity = new OrderEntity();
		ordEntity.setOrderDate(today);

		AccountEntity accEntity = new AccountEntity();
		accEntity.setAcctType("Resident");
		accEntity.setCustAddress("100 Hello dr");
		accEntity.setCustName("Paul");

		ServiceImplEntity srvEntity = new ServiceImplEntity();
		srvEntity.setServiceId(100);
		srvEntity.setName("Voice");
		srvEntity.setProdDesc("4G LTE");
		List<ServiceImplEntity> seList = new ArrayList<>();
		
		ProductEntity pEntity = new ProductEntity();
		pEntity.setPid(1);
		pEntity.setDescription("iPhone");
		pEntity.setRate(900);
		List<ProductEntity> peList = new ArrayList<>();
		peList.add(pEntity);

		srvEntity.setProductList(peList);
		seList.add(srvEntity);

		accEntity.setService(seList);

		ordEntity.setAccount(accEntity);
		
		List<OrderEntity> orderList = new ArrayList<>();
		orderList.add(ordEntity);
		//if get order method in orderService calls the orderRepository.findById
		//then return ordEntity
		Mockito.when(orderRepository.findAll()).thenReturn(orderList);
		assertThat(orderService.getallorders()).isEqualTo(orderList);
	}
	
	
	@Test
	public void invalidDeleteOrderById() throws Exception {
		LocalDate today = LocalDate.now();
		OrderEntity ordEntity = new OrderEntity();
		ordEntity.setOrderDate(today);

		AccountEntity accEntity = new AccountEntity();
		accEntity.setAcctType("Resident");
		accEntity.setCustAddress("100 Hello dr");
		accEntity.setCustName("Paul");

		ServiceImplEntity srvEntity = new ServiceImplEntity();
		srvEntity.setServiceId(100);
		srvEntity.setName("Voice");
		srvEntity.setProdDesc("4G LTE");
		List<ServiceImplEntity> seList = new ArrayList<>();
		
		ProductEntity pEntity = new ProductEntity();
		pEntity.setPid(1);
		pEntity.setDescription("iPhone");
		pEntity.setRate(900);
		List<ProductEntity> peList = new ArrayList<>();
		peList.add(pEntity);

		srvEntity.setProductList(peList);
		seList.add(srvEntity);

		accEntity.setService(seList);

		ordEntity.setAccount(accEntity);
		
		ee.expect(Exception.class);
		ee.expectMessage("Order with the order id was not found");
		assertThat(orderService.deleteOrder(ordEntity.getOrderId())).isEmpty();;
//		assertNull(orderRepository.existsById(ordEntity.getOrderId()));
		
	}
	
	
}
