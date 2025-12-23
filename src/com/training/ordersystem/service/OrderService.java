package com.training.ordersystem.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.training.ordersystem.dao.OrderDAO;
import com.training.ordersystem.model.*;

public class OrderService {
	
	private OrderDAO orderDAO = new OrderDAO();
	private static final String FILE_PATH = "orders.txt";
	
	// Order Creation and Saving
	public Order createOrder(Profile profile, List<Item> items) {
		
		String orderId = OrderIdGenerator.generateOrderId();
		
		int totalCost = calculateTotalCost(items);
		
		Order order = new Order(orderId, profile, items, totalCost);
		
		orderDAO.saveOrder(order);
		
		return order;
		
	}
	
	// Calculate Total Cost
	private int calculateTotalCost( List<Item> items) {
		
		int total = 0;
		for (Item item : items ) {
			total += item.getItemPrice();
		}
		return total;
	}
	
	// Retrieve Order based on Order Id
	public Order getOrder(String orderId) {
		Order order = orderDAO.getOrderById(orderId);
		return order;
	}
	
	// Orders file reset to be called at start of the Main class
    public void initializeFile() {
        try (PrintWriter pw = new PrintWriter(FILE_PATH)) {
            pw.print(""); // clears file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
