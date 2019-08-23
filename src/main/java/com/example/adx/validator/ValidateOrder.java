
package com.example.adx.validator;


import java.time.LocalDate;

import com.example.adx.entity.OrderEntity;

public class ValidateOrder {
	
	public static void validateOrder(OrderEntity order) throws Exception {
		
		if(!validateCustomerName(order.getAccount().getCustName()))
			throw new Exception("ValidateOrder.INVALID_CUSTOMER_NAME".toUpperCase());
		if(!validateAccountType(order.getAccount().getAcctType()))
			throw new Exception("ValidateOrder.INVALID_ACCOUNT_TYPE");
		if(!validateCustomerAddress(order.getAccount().getCustAddress()))
			throw new Exception("ValidateOrder.INVALID_CUSTOMER_ADDRESS");
		if (!validateOrderDate(order.getOrderDate()))
			throw new Exception("ValidateOrder.INVALID_ORDER_DATE");
		
	}
	
	
	public static Boolean validateOrderDate(LocalDate orderDate) {
		LocalDate today = LocalDate.now();
		return orderDate.isEqual(today);
	}
	
	public static Boolean validateCustomerName(String name) {
		String regex = "([A-Za-z])+(\\s[A-Za-z]+)*";
		return name.matches(regex);
	}
	
	public static Boolean validateAccountType(String acctType) {
		String regex ="Resident|Commercial|Enterprise";
		return acctType.matches(regex);
	}
	
	public static Boolean validateCustomerAddress (String address) {
		String regex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
		return address.matches(regex);
	}


}
