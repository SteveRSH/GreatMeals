package com.theironyard.charlotte.GreatMeals.controllers;

import com.theironyard.charlotte.GreatMeals.models.database.Inventory;
import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import com.theironyard.charlotte.GreatMeals.models.database.Transaction;
import com.theironyard.charlotte.GreatMeals.models.database.User;
import com.theironyard.charlotte.GreatMeals.repository.InventoryRepository;
import com.theironyard.charlotte.GreatMeals.repository.RestaurantRepository;
import com.theironyard.charlotte.GreatMeals.repository.TransactionRepository;
import com.theironyard.charlotte.GreatMeals.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@RestController
public class LastMealGreatDealController {
    @Autowired
    InventoryRepository inventoryRepo;

    @Autowired
    RestaurantRepository restaurantRepo;

    @Autowired
    TransactionRepository transactionRepo;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/")
    public void homePage() {
        Set<Transaction> tranSet = new HashSet<Transaction>();
        Transaction transaction1 = new Transaction();
        transaction1.setTotal(132.50);
        Transaction transaction2 = new Transaction();
        transaction2.setTotal(100.50);

        tranSet.add(transaction1);
        tranSet.add(transaction2);

        User user = new User();
        User userExists = userRepo.findFirstByUsername("test@test.com");

        if (userExists == null) {
            user.setUsername("test@test.com");
            user.setPassword("test");
            user.setTransaction(tranSet);
            userRepo.save(user);
        }

        Restaurant restaurant = new Restaurant();
        Restaurant restaurantExists = restaurantRepo.findFirstByUsername("place@place.com");

        if (restaurantExists == null) {
            restaurant.setYelp_id("the_food_place");
            restaurant.setUsername("place@place.com");
            restaurant.setPassword("place");
            restaurant.setTransaction(tranSet);
            restaurantRepo.save(restaurant);
        }

        Inventory inventory = new Inventory();
//        Inventory inventoryExists = inventoryRepo.findFirstByRestaurant(restaurant);
        Inventory inventoryExists = null;
//
        if (inventoryExists == null) {
            inventory.setRestaurant(restaurant);
            inventory.setDescription("kale burger");
            inventory.setNum_available(10);
            inventory.setPrice(10.99);
            inventory.setPrice(10.99);
            inventory.setPickup_start(Time.valueOf("22:00:00"));
            inventory.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory);
        }


        transaction1.setRestaurant(restaurant);
        transaction2.setRestaurant(restaurant);
        transaction1.setUser(user);
        transaction2.setUser(user);
        transactionRepo.save(tranSet);
    }

}
