package com.training.ordersystem.model;

public class Item {
	
	String itemName;
	float itemPrice;
	
	public Item(String itemName, int itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	//Getters
	public String getItemName() { return itemName; }
	public float getItemPrice() { return itemPrice; }
	//Setters
	public void setItemName(String itemName) { this.itemName = itemName; }
	public void setItemPrice(float itemPrice) { this.itemPrice = itemPrice; }

	@Override
	public String toString() {
		return "Item [Item Name = " + itemName + ", Price = " + itemPrice + " ]";
	}	
	

}
