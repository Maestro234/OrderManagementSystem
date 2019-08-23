package com.example.adx.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.adx.entity.AccountEntity;
import com.example.adx.entity.OrderEntity;
import com.example.adx.entity.ProductEntity;
import com.example.adx.entity.ServiceImplEntity;
import com.example.adx.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@WebMvcTest(value=OrderController.class)
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OrderService orderService;
	
//	@Test
//	public void createOrder() throws Exception {
//		LocalDate today = LocalDate.now();
//		OrderEntity ordEntity = new OrderEntity();
//		ordEntity.setOrderDate(today);
//
//		AccountEntity accEntity = new AccountEntity();
//		accEntity.setAcctType("Resident");
//		accEntity.setCustAddress("100 Hello dr");
//		accEntity.setCustName("Paul");
//
//		ServiceImplEntity srvEntity = new ServiceImplEntity();
//		srvEntity.setServiceId(100);
//		srvEntity.setName("Voice");
//		srvEntity.setProdDesc("4G LTE");
//		List<ServiceImplEntity> seList = new ArrayList<>();
//		
//		ProductEntity pEntity = new ProductEntity();
//		pEntity.setPid(1);
//		pEntity.setDescription("iPhone");
//		pEntity.setRate(900);
//		List<ProductEntity> peList = new ArrayList<>();
//		peList.add(pEntity);
//
//		srvEntity.setProductList(peList);
//		seList.add(srvEntity);
//
//		accEntity.setService(seList);
//
//		ordEntity.setAccount(accEntity);
//		
//		String inputJson = this.mapToJson(ordEntity);
//		
//		Mockito.when(orderService.createOrder(Mockito.any(OrderEntity.class))).thenReturn("Order has been successfully created");
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/demo/createorder")
//				.accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
//				.contentType(MediaType.APPLICATION_JSON_VALUE);
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		
//		String outputJson = response.getContentAsString();
//		
//		assertThat(outputJson).isEqualToIgnoringCase("Order has been successfully created");
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
//		
//	}
	
	
	
	//maps an object into a json string using Jackson ObjectMapper
//	public String mapToJson(Object object) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(object);
//	}

	
}
