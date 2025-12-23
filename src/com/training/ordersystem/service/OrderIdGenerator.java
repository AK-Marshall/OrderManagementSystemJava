package com.training.ordersystem.service;

// Generates Order ID
public class OrderIdGenerator {
	
	public static int counter = 1;
	
	public static String generateOrderId() {
		counter ++;
		return String.format("OID%06d", counter);
		
	}

}
