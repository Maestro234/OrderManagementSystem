package com.example.adx.service;


import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.adx.entity.OrderEntity;
import com.example.adx.entity.ProductEntity;
import com.example.adx.entity.ServiceImplEntity;
import com.example.adx.repository.OrderRepository;
import com.example.adx.repository.ProductRepository;
import com.example.adx.repository.ServiceRepository;
import com.example.adx.validator.ValidateOrder;

@Service(value = "orderService")
@Transactional(readOnly=true)	//for optimization
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ServiceRepository serviceRepository;


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public String createOrder(OrderEntity order) throws Exception{
		
			ValidateOrder.validateOrder(order);
			
			if(order.getAccount().getService().isEmpty())
				throw new Exception("Service cannot be empty");
			order.getOrderDate();
			List<ServiceImplEntity> sList = new ArrayList<>();
			for(ServiceImplEntity se : order.getAccount().getService()) {
				boolean isServiceExisting = serviceRepository.existsById(se.getServiceId());
				if(!isServiceExisting) {
					throw new Exception("Service Id does not exits in catalog");
				}
				Optional<ServiceImplEntity> sEntity = serviceRepository.findById(se.getServiceId());
				ServiceImplEntity serviceEntity = sEntity.get();
				
				List<ProductEntity> peList = new ArrayList<>();
				for(ProductEntity pe : se.getProductList()) {
					boolean isProductExisting = productRepository.existsById(pe.getPid());
					if (!isProductExisting) {
						throw new Exception("Product Id Does not exits in catalog");
					}
					Optional<ProductEntity> pEntity = productRepository.findById(pe.getPid());
					ProductEntity productEntity = pEntity.get();
					peList.add(productEntity);
				}
				serviceEntity.setProductList(peList);
				sList.add(serviceEntity);
			}
			
			orderRepository.saveAndFlush(order);
			return "Order has been successfully created";
	}
	
	

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public String updateOrder(OrderEntity order) throws Exception {
		
		boolean orderExistInDB = orderRepository.existsById(order.getOrderId());
		if (!orderExistInDB) {
			throw new Exception("Order was not found");
		}
		
		if(order.getAccount().getService().isEmpty())
			throw new Exception("Service cannot be empty");
		order.getOrderDate();
		List<ServiceImplEntity> sList = new ArrayList<>();
		for(ServiceImplEntity se : order.getAccount().getService()) {
			boolean isServiceExisting = serviceRepository.existsById(se.getServiceId());
			if(!isServiceExisting) {
				throw new Exception("Service Id does not exits in catalog");
			}
			Optional<ServiceImplEntity> sEntity = serviceRepository.findById(se.getServiceId());
			ServiceImplEntity serviceEntity = sEntity.get();
			
			List<ProductEntity> peList = new ArrayList<>();
			for(ProductEntity pe : se.getProductList()) {
				boolean isProductExisting = productRepository.existsById(pe.getPid());
				if (!isProductExisting) {
					throw new Exception("Product Id Does not exits in catalog");
				}
				Optional<ProductEntity> pEntity = productRepository.findById(pe.getPid());
				ProductEntity productEntity = pEntity.get();
				peList.add(productEntity);
			}
			serviceEntity.setProductList(peList);
			sList.add(serviceEntity);
		}
		
		orderRepository.saveAndFlush(order);
		
		return "Order has been Updated";
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public String deleteOrder(Integer orderId) throws Exception {
		Optional<OrderEntity> order = orderRepository.findById(orderId);
		if (!order.isPresent()) {
			throw new Exception("Order with the order id was not found");
		}

		orderRepository.deleteById(orderId);
		return "Order with order id: " + orderId + " has been deleted";
	}

	@Override
	public List<OrderEntity> getallorders() {
		return orderRepository.findAll();
	}

	@Override
	public OrderEntity getorder(Integer orderId) throws Exception {
		OrderEntity order = orderRepository.getOne(orderId);
		if(order == null) {
			throw new Exception("Order does not exist");
		}
		return order;
	}
	

}
