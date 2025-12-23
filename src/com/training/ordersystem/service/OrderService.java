package com.training.ordersystem.service;

import java.util.List;
import com.training.ordersystem.dao.OrderDAO;
import com.training.ordersystem.model.*;

public class OrderService {
	
	private OrderDAO orderDAO = new OrderDAO();
	
	
	// Order Creation and Saving
	public Order createOrder(Profile profile, List<Item> items) {
		
		String orderId = OrderIdGenerator.generateOrderId();
		
		float totalCost = calculateTotalCost(items);
		
		Order order = new Order(orderId, profile, items, totalCost);
		
		orderDAO.saveOrder(order);
		
		return order;
		
	}
	
	// Calculate Total Cost
	private float calculateTotalCost( List<Item> items) {
		
		float total = 0;
		for (Item item : items ) {
			total += item.getItemPrice();
		}
		return total;
	}
	
	// Retrieve Order based on Order Id
	
	public Order getOrder(String orderId) {
		Order order = orderDAO.getOrderDetails(orderId);
		return order;
	}
	

}
