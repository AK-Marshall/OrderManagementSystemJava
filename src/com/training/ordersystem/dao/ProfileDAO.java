package com.training.ordersystem.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.training.ordersystem.model.Profile;

public class ProfileDAO {


    public List<Profile> getAllProfiles() {

        List<Profile> profiles = new ArrayList<>();

        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("profile.txt");

            if (is == null) {
                throw new RuntimeException("profile.txt not found in resources");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {

                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] data = line.split("\\|");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String email = data[2].trim();

                profiles.add(new Profile(id, name, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return profiles;
    }
}

