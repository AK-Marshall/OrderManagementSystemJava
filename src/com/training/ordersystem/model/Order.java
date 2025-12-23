package com.training.ordersystem.model;
import java.util.List;

public class Order {
	
	private String orderId;
	private Profile profile;
	private List<Item> items;
	private int totalCost;
	
	// Constructor
	public Order(String orderId, Profile profile, List<Item> items, int totalCost2) {
		this.orderId = orderId;
		this.profile = profile;
		this.items = items;
		this.totalCost = totalCost2;
	}
	
	// Getters
	public String getOrderId() { return orderId; }
	public Profile getProfile() { return profile; }
	public List<Item> getItems() { return items; }
	public int getTotalCost() { return totalCost; }

	// Setters
	public void setOrderId(String orderId) { this.orderId = orderId; }
	public void setProfile(Profile profile) { this.profile = profile; }
	public void setItems(List<Item> items) { this.items = items; }
	public void setTotalCost(int totalCost) { this.totalCost = totalCost; }

	@Override
	public String toString() {
		return "Order [Order ID = " + orderId + ", Profile = " + profile + ", Items = " + items + ", Total Cost = " + totalCost
				+ " ]";
	}
	
}
