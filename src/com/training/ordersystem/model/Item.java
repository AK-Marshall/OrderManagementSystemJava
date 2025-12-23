package com.training.ordersystem.model;

public class Item {
	
	String itemName;
	int itemPrice;
	
	// Constructor
	public Item(String itemName, int itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	// Getters
	public String getItemName() { return itemName; }
	public int getItemPrice() { return itemPrice; }
	
	// Setters
	public void setItemName(String itemName) { this.itemName = itemName; }
	public void setItemPrice(int itemPrice) { this.itemPrice = itemPrice; }

	@Override
	public String toString() {
		return "Item [Item Name = " + itemName + ", Price = " + itemPrice + " ]";
	}	
	

}
