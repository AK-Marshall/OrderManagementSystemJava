package com.training.ordersystem.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.ordersystem.controller.OrderController;
import com.training.ordersystem.controller.ProfileController;
import com.training.ordersystem.model.Order;
import com.training.ordersystem.model.Item;
import com.training.ordersystem.model.Profile;

public class OrderSystemUI {
		
	
	public static void main(String[] args) {
	
	    Scanner sc = new Scanner(System.in);
	    ProfileController profileController = new ProfileController();
	    OrderController orderController = new OrderController();
	    orderController.initializeOrderStorage(); // Orders File Reset

	    
	    while (true) {
	
	        System.out.println("\n===== ORDER SYSTEM =====");
	        System.out.println("1. Create New Order");
	        System.out.println("2. Retrieve Order");
	        System.out.println("0. Exit");
	        System.out.print("Enter choice: ");
	
	        int option = sc.nextInt();
	        sc.nextLine(); 
	
	        if (option == 0) {
	            System.out.println("Exiting Order System. Goodbye!");
	            break;
	        }
	
	        // Create and Store Orders in Orders Text File
	        if (option == 1) {
	        	
	        	// Profile Available 
	            System.out.println("Available Profiles:");
	            List<Profile> profiles = profileController.getAllProfiles();
	            for (Profile profile : profiles) {
	                System.out.println(profile);
	            }
	            
	            // User Input for choosing the User
	            System.out.print("Enter User ID: ");
	            int userId = sc.nextInt();
	            sc.nextLine();
	
	            Profile selectedProfile = profileController.getProfileById(userId);
	
	            if (selectedProfile == null) {
	                System.out.println("Invalid User ID.");
	                continue; 
	            }
	
	            List<Item> items = new ArrayList<>();
	            String choice;
	            
	            // Item Name and Price input loop
	            do {
	                System.out.print("Enter Item Name: ");
	                String itemName = sc.nextLine();
	
	                System.out.print("Enter Item Price: ");
	                int itemPrice = sc.nextInt();
	                sc.nextLine();
	
	                items.add(new Item(itemName, itemPrice));
	
	                System.out.print("Add another item? [Y/N]: ");
	                choice = sc.nextLine().trim().toLowerCase();
	
	            } while (choice.equals("y"));
	
	            Order order = orderController.createOrder(selectedProfile, items);
	
	            System.out.println("\nOrder Created Successfully");
	            System.out.println("Order ID          : " + order.getOrderId());
	            System.out.println("Customer Name     : " + order.getProfile().getUserName());
	            System.out.println("Customer Email ID : " + order.getProfile().getUserEmail());
	            System.out.println("Items             :");
	
	            for (Item item : order.getItems()) {
	                System.out.printf("-  : ",
	                        item.getItemName(),
	                        item.getItemPrice());
	            }
	
	            System.out.printf("Total Cost        : ₹",order.getTotalCost());
	        }
	
	        // Retrieve Order based on Order ID
	        else if (option == 2) {
	
	            System.out.print("Enter Order ID: ");
	            String orderId = sc.nextLine();
	
	            Order order = orderController.getOrderById(orderId);
	
	            if (order == null) {
	                System.out.println("Order not found.");
	            } else {
	                System.out.println("Order ID          : " + order.getOrderId());
	                System.out.println("Customer Name     : " + order.getProfile().getUserName());
	                System.out.println("Customer Email ID : " + order.getProfile().getUserEmail());
	                System.out.println("Items");
	
	                for (Item item : order.getItems()) {
	                    System.out.printf("- %-15s : ₹%d%n",
	                            item.getItemName(),
	                            item.getItemPrice());
	                }
	
	                System.out.printf("Total Cost        : ₹%d%n", order.getTotalCost());
	            }
	        }
	
	        else {
	            System.out.println("Invalid choice. Try again.");
	        }
	    }
	
	    sc.close();
	}
}

