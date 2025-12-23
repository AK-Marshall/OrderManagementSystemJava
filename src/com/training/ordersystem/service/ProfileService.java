package com.training.ordersystem.service;

import java.util.List;

import com.training.ordersystem.dao.ProfileDAO;
import com.training.ordersystem.model.Profile;

public class ProfileService {
	
	private ProfileDAO profileDAO = new ProfileDAO();
	
	
	// Get All Profiles
	public List<Profile> getAllProfiles() {
		return profileDAO.getAllProfiles();
	}
	
	// Get Profile by User Id
	public Profile getProfileById(int userId) {
		
		List<Profile> profiles = profileDAO.getAllProfiles();
		
		for(Profile profile : profiles) {
			if(profile.getUserId() == userId) {
				return profile;
			}
			
		}
		
		return null;
		
	}
	
	

}
