package com.example.adx.service;

import java.util.List;

import com.example.adx.entity.OrderEntity;

public interface OrderService {

	public String createOrder(OrderEntity order) throws Exception;
	public String updateOrder(OrderEntity order) throws Exception;
	public String deleteOrder(Integer accountId) throws Exception;
	public OrderEntity getorder(Integer orderId) throws Exception;
	public List<OrderEntity> getallorders();
}
