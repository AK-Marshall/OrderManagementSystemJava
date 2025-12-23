package com.training.ordersystem.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.training.ordersystem.model.Item;
import com.training.ordersystem.model.Order;
import com.training.ordersystem.model.Profile;

public class OrderDAO {

    private static final String FILE_PATH = "orders.txt";

    // Clear Orders file at start
    public void initializeFile() {
        try (PrintWriter pw = new PrintWriter(FILE_PATH)) {
            pw.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save order into Orders Text file
    public void saveOrder(Order order) {

        try (FileWriter fw = new FileWriter(FILE_PATH, true)) {

            // Items 
            StringBuilder itemsData = new StringBuilder();
            for (Item item : order.getItems()) {
                itemsData.append(item.getItemName())
                         .append(":")
                         .append(item.getItemPrice())
                         .append(",");
            }
            itemsData.deleteCharAt(itemsData.length() - 1);

            // Profile data
            Profile p = order.getProfile();
            String profileData = p.getUserId() + "," +
                                 p.getUserName() + "," +
                                 p.getUserEmail();

            String line = order.getOrderId() + "|" +
                          profileData + "|" +
                          itemsData + "|" +
                          order.getTotalCost();

            fw.write(line + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retrieve Order by Order ID
    public Order getOrderById(String orderId) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts[0].equals(orderId)) {

                    // Profile
                    String[] profileParts = parts[1].split(",");
                    int userId = Integer.parseInt(profileParts[0]);
                    String userName = profileParts[1];
                    String userEmail = profileParts[2];

                    Profile profile = new Profile(userId, userName, userEmail);

                    // Items
                    List<Item> items = new ArrayList<>();
                    String[] itemParts = parts[2].split(",");

                    for (String item : itemParts) {
                        String[] data = item.split(":");
                        items.add(new Item(data[0], Integer.parseInt(data[1])));
                    }

                    int totalCost = Integer.parseInt(parts[3]);

                    return new Order(orderId, profile, items, totalCost);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
