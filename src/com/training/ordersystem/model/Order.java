package com.training.ordersystem.model;
import java.util.List;

public class Order {
	
	private String orderId;
	private Profile profile;
	private List<Item> items;
	private float totalCost;
	
	
	public Order(String orderId, Profile profile, List<Item> items, float totalCost) {
		this.orderId = orderId;
		this.profile = profile;
		this.items = items;
		this.totalCost = totalCost;
	}
	
	// Getters
	public String getOrderId() { return orderId; }
	public Profile getProfile() { return profile; }
	public List<Item> getItems() { return items; }
	public float getTotalCost() { return totalCost; }

	// Setters
	public void setOrderId(String orderId) { this.orderId = orderId; }
	public void setProfile(Profile profile) { this.profile = profile; }
	public void setItems(List<Item> items) { this.items = items; }
	public void setTotalCost(float totalCost) { this.totalCost = totalCost; }

	@Override
	public String toString() {
		return "Order [Order ID = " + orderId + ", Profile = " + profile + ", Items = " + items + ", Total Cost = " + totalCost
				+ " ]";
	}

	

	
	
	
	
	
	
}
