package com.training.ordersystem.controller;

import java.util.List;

import com.training.ordersystem.model.Item;
import com.training.ordersystem.model.Order;
import com.training.ordersystem.model.Profile;
import com.training.ordersystem.service.OrderService;

public class OrderController {
	
	private OrderService orderService = new OrderService();
	
	// Orders File Reset
	public void initializeOrderStorage() {
        orderService.initializeFile();
    }
	// Creating Order
	public Order createOrder(Profile profile, List<Item> items) {
		return orderService.createOrder(profile, items);
	}
	// Retrieve Order based on Order ID
	public Order getOrderById(String orderId) {
		return orderService.getOrder(orderId);
	}
	
}
