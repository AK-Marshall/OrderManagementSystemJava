package com.training.ordersystem.dao;

import java.util.ArrayList;
import java.util.List;
import com.training.ordersystem.model.Order;

public class OrderDAO {
	
	private List<Order> orderList = new ArrayList<>();
	
	// Save a new order
	public void saveOrder(Order order) {
		
		orderList.add(order);
	}
	
	// Returns order based on order ID
	public Order getOrderDetails(String orderId) {
		
		for(Order order : orderList ) {
			
			if( order.getOrderId().equals(orderId)) 
				
				return order;
		}
		
		return null;
	}
	
}
