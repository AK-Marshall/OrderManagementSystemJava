package com.training.ordersystem.service;

public class OrderIdGenerator {
	
	public static int counter = 1;
	
	public static String generateOrderId() {
		counter ++;
		return String.format("OID%06d", counter);
		
	}

}
