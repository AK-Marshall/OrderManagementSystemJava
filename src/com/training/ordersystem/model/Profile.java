package com.training.ordersystem.model;

public class Profile {
	
	private String userName;
	private String userEmail;
	private int userId;
	
	public Profile(int userId, String userName, String userEmail) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	//Setters
	public void setUserName(String userName) { this.userName = userName; }
	public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
	public void setUserId(int userId) { this.userId = userId; }
	
	//Getters
	public String getUserName() { return userName; }
	public String getUserEmail() { return userEmail; }
	public int getUserId() { return userId; }
	
	@Override
	public String toString() {
		return "Profile [ User ID = " + userId + ", Username = " + userName + ", Email ID = " + userEmail + " ] ";
	}
	
}
