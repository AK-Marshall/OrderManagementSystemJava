package com.training.ordersystem.controller;

import java.util.List;

import com.training.ordersystem.service.ProfileService;
import com.training.ordersystem.model.Profile;

public class ProfileController {
	
	private ProfileService profileService = new ProfileService();
	
	//Return all Profiles
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}
	
	// Return profile by User ID
	public Profile getProfileById(int userId) {
		return profileService.getProfileById(userId);
	}
	
}
