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
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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


    @CrossOrigin
    @GetMapping("/")
    public void renderHomePage() {
        Set<Transaction> tranSet = new HashSet<>();
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
            userRepo.save(user);

            //TODO: build transactions to reference user
        }

        Restaurant restaurantExists = restaurantRepo.findFirstByUsername("place@place.com");

        if (restaurantExists == null) {
            Restaurant restaurant = new Restaurant();

            restaurant.setYelp_id("the_food_place");
            restaurant.setUsername("place@place.com");
            restaurant.setPassword("place");
            restaurantRepo.save(restaurant);

            Inventory inventory = new Inventory();

            inventory.setRestaurant(restaurant);
            inventory.setDescription("kale burger");
            inventory.setNum_available(10);
            inventory.setPrice(10.99);
            inventory.setPrice(10.99);
            inventory.setPickup_start(Time.valueOf("22:00:00"));
            inventory.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory);

            transaction1.setRestaurant(restaurant);
            transaction2.setRestaurant(restaurant);
            transaction1.setUser(user);
            transaction2.setUser(user);
            transactionRepo.save(tranSet);
        }

//        Inventory inventoryExists = inventoryRepo.findFirstByRestaurant(restaurant);
    }


    //********* RESTAURANT CONTROLLERS START HERE *******//


//    @CrossOrigin
//    @GetMapping("/signin")
//    public void restaurantSignIn() {

//
//    }
//
//    @CrossOrigin
//    @GetMapping("/logout")
//    public void restaurantLogout() {
//
//    }

    @CrossOrigin
    @GetMapping("/inventory")
    public List<Inventory> getAllInventory() {
        // TODO: if session owner is restaurant,
        // TODO: list all inventory with username of that restaurant.

        List<Inventory> allInventory = (List<Inventory>) inventoryRepo.findAll();

        return allInventory;
    }

//    @CrossOrigin
//    @GetMapping("/inventory")
//    public List<Inventory> sortInventory() {
//        List<Inventory> allInventory = (List<Inventory>) inventoryRepo.findAll().;
//
//        return allInventory;
//        //return all inventory from psql
//        ///restaurant/{yelp_id}/inventory?sort=<field name><direction>
//        //use query params and sort the render
//    }
//
//    @CrossOrigin
//    @GetMapping("/restaurant/{yelp_id}/inventory")
//    public void searchInventoryByDescription() {
//        //return all inventory from psql
//        ///restaurant/{yelp_id}/transactions/search?q={query}
//        //use query params and search
//    }
//
//    @CrossOrigin
//    @PostMapping("/restaurant/{yelp_id}/inventory")
//    public void addToInventory() {
//        //add to inventory when prompted
//
//    }
//
//    @CrossOrigin
//    @DeleteMapping("/restaurant/{yelp_id}/inventory")
//    public void deleteFromInventory() {
//        //delete from inventory when prompted
//    }
//
//    @CrossOrigin
//    @PutMapping("/restaurant/{yelp_id}/inventory")
//    public void editInventoryItem() {
//        //replace inventory with edited item
//    }

    @CrossOrigin
    @GetMapping("/transactions")
    public List<Transaction> getAllRestaurantTransactions() {
        //TODO: if session owner is a restaurant, find all transactions where
        //TODO: session owners username is in restaurant db

        List<Transaction> allTransactions = (List<Transaction>) transactionRepo.findAll();

        return allTransactions;
    }

//    @CrossOrigin
//    @GetMapping("/restaurant/{yelp_id}/inventory")
//    public void sortRestaurantTransactions() {
//        //sort transactions by date
//    }
//
//    @CrossOrigin
//    @GetMapping("/restaurant/{yelp_id}/inventory")
//    public void searchTransactionsByCustomer() {
//        //search transactions by customer name
//    }

    //*************************************************//

    //********* CUSTOMER CONTROLLERS START HERE *******//

//
//    @CrossOrigin
//    @GetMapping("/customer")
//    public void renderAllRestaurants() {
//        //return all restaurants in area
//    }
//
//    @CrossOrigin
//    @GetMapping("/customer/restaurants/sort=<field name><direction>")
//    public void sortRestaurants() {
//        //return all restaurants in area
//    }
//
//    @CrossOrigin
//    @GetMapping("/customer/restaurants/search?q=query")
//    public void searchRestaurantsByName() {
//        //return all restaurants in area
//    }
//
    @CrossOrigin
    @GetMapping("/transactions")
    public List<Transaction> getAllCustomerTransactions() {
        // TODO: if the session owner is customer,
        // TODO: get all transactions with session owners username

        List<Transaction> allTransactions = (List<Transaction>) transactionRepo.findAll();

        return allTransactions;
    }
//
//    @CrossOrigin
//    @GetMapping("/customer/restaurants/transactions")
//    public void sortCustomerTransactions() {
//        //return all restaurants in area
//    }
//    @CrossOrigin
//    @GetMapping("/customer/restaurants/transactions")
//    public void searchTransactionsByRestaurant() {
//        //return all restaurants in area
//    }

    @CrossOrigin
    @GetMapping("/restaurants/{yelp_id}")
    public Restaurant viewRestaurantDetails() {
        restaurantRepo.findOne(id == ).getId()
    }

//    @CrossOrigin
//    @GetMapping("/customer/restaurants/transactions")
//    public void addToCart() {
//        //return all restaurants in area
//    }
//    @CrossOrigin
//    @GetMapping("/customer/restaurants/transactions")
//    public void payForFood() {
//        //return all restaurants in area
//    }
//    @CrossOrigin
//    @GetMapping("/customer/restaurants/transactions")
//    public void confirmation() {
//        //return all restaurants in area
//    }
    //*************************************************//
}
