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

        Restaurant restaurantExists1 = restaurantRepo.findFirstByUsername("lempira-restaurant@lempira.com");
        Restaurant restaurantExists2 = restaurantRepo.findFirstByUsername("catrachos@catrachos.com");
        Restaurant restaurantExists3 = restaurantRepo.findFirstByUsername("georges@georges.com");
        Restaurant restaurantExists4 = restaurantRepo.findFirstByUsername("salad-chick@salad-chick.com");
        Restaurant restaurantExists5 = restaurantRepo.findFirstByUsername("pollo-campero@campero.com");
        Restaurant restaurantExists6 = restaurantRepo.findFirstByUsername("rosies-kitchen@rosies.com");
        Restaurant restaurantExists7 = restaurantRepo.findFirstByUsername("mr-pollo@pollo.com");
        Restaurant restaurantExists8 = restaurantRepo.findFirstByUsername("roasting-co@roasting.com");
        Restaurant restaurantExists9 = restaurantRepo.findFirstByUsername("asalad-chick@asalad-chick.com");
        Restaurant restaurantExists10 = restaurantRepo.findFirstByUsername("johnnys-farmhouse@farmhouse.com");
        Restaurant restaurantExists11 = restaurantRepo.findFirstByUsername("mr-cs@mcs.com");
        Restaurant restaurantExists12 = restaurantRepo.findFirstByUsername("chicken-bucket@bucket.com");
        Restaurant restaurantExists13 = restaurantRepo.findFirstByUsername("el-mariachi@mariachi.com");
        Restaurant restaurantExists14 = restaurantRepo.findFirstByUsername("dragon-buffett@dragonbuffett.com");
        Restaurant restaurantExists15 = restaurantRepo.findFirstByUsername("antojitos-catrachos@antojitoscatrachos.com");



        if (restaurantExists1 == null &&
                restaurantExists2 == null &&
                restaurantExists3 == null &&
                restaurantExists4 == null &&
                restaurantExists5 == null &&
                restaurantExists6 == null &&
                restaurantExists7 == null &&
                restaurantExists8 == null &&
                restaurantExists9 == null &&
                restaurantExists10 == null &&
                restaurantExists11 == null &&
                restaurantExists12 == null &&
                restaurantExists13 == null &&
                restaurantExists14 == null &&
                restaurantExists15 == null) {
            Restaurant restaurant1 = new Restaurant();
            Restaurant restaurant2 = new Restaurant();
            Restaurant restaurant3 = new Restaurant();
            Restaurant restaurant4 = new Restaurant();
            Restaurant restaurant5 = new Restaurant();
            Restaurant restaurant6 = new Restaurant();
            Restaurant restaurant7 = new Restaurant();
            Restaurant restaurant8 = new Restaurant();
            Restaurant restaurant9 = new Restaurant();
            Restaurant restaurant10 = new Restaurant();
            Restaurant restaurant11 = new Restaurant();
            Restaurant restaurant12 = new Restaurant();
            Restaurant restaurant13 = new Restaurant();
            Restaurant restaurant14 = new Restaurant();
            Restaurant restaurant15 = new Restaurant();

            restaurant1.setYelp_id("lempira-restaurant-charlotte-3");
            restaurant1.setUsername("lempira-restaurant@lempira.com");
            restaurant1.setPassword("12345");
            restaurantRepo.save(restaurant1);


            restaurant2.setYelp_id("antojitos-catrachos-charlotte");
            restaurant2.setUsername("catrachos@catrachos.com");
            restaurant2.setPassword("abcde");
            restaurantRepo.save(restaurant2);

            restaurant3.setYelp_id("georges-brasserie-charlotte");
            restaurant3.setUsername("georges@georges.com");
            restaurant3.setPassword("htksit");
            restaurantRepo.save(restaurant3);


            restaurant4.setYelp_id("chicken-salad-chick-charlotte-3");
            restaurant4.setUsername("salad-chick@salad-chick.com");
            restaurant4.setPassword("kdowd");
            restaurantRepo.save(restaurant4);

            restaurant5.setYelp_id("pollo-campero-charlotte");
            restaurant5.setUsername("pollo-campero@campero.com");
            restaurant5.setPassword("utllld");
            restaurantRepo.save(restaurant5);


            restaurant6.setYelp_id("rosies-kitchen-charlotte");
            restaurant6.setUsername("rosies-kitchen@rosies.com");
            restaurant6.setPassword("8392hd");
            restaurantRepo.save(restaurant6);

            restaurant7.setYelp_id("mr-pollo-fort-mill");
            restaurant7.setUsername("mr-pollo@pollo.com");
            restaurant7.setPassword("84osjb");
            restaurantRepo.save(restaurant7);


            restaurant8.setYelp_id("roasting-co-rock-hill");
            restaurant8.setUsername("roasting-co@roasting.com");
            restaurant8.setPassword("w34fht");
            restaurantRepo.save(restaurant8);

            restaurant9.setYelp_id("chicken-salad-chick-concord");
            restaurant9.setUsername("asalad-chick@asalad-chick.com");
            restaurant9.setPassword("u39384");
            restaurantRepo.save(restaurant9);

            restaurant10.setYelp_id("johnnys-farmhouse-restaurant-concord");
            restaurant10.setUsername("johnnys-farmhouse@farmhouse.com");
            restaurant10.setPassword("xdiwfjkf");
            restaurantRepo.save(restaurant10);


            restaurant11.setYelp_id("mr-cs-concord");
            restaurant11.setUsername("mr-cs@mcs.com");
            restaurant11.setPassword("keiioan");
            restaurantRepo.save(restaurant11);

            restaurant12.setYelp_id("chicken-bucket-mount-holly");
            restaurant12.setUsername("chicken-bucket@bucket.com");
            restaurant12.setPassword("hejisid");
            restaurantRepo.save(restaurant12);


            restaurant13.setYelp_id("el-mariachi-2-charlotte");
            restaurant13.setUsername("el-mariachi@mariachi.com");
            restaurant13.setPassword("833dii");
            restaurantRepo.save(restaurant13);

            restaurant14.setYelp_id("dragon-buffett-cornelius");
            restaurant14.setUsername("dragon-buffett@dragonbuffett.com");
            restaurant14.setPassword("iiisehe");
            restaurantRepo.save(restaurant14);


            restaurant15.setYelp_id("antojitos-catrachos-charlotte");
            restaurant15.setUsername("antojitos-catrachos@antojitoscatrachos.com");
            restaurant15.setPassword("ieieidj");
            restaurantRepo.save(restaurant15);

            Inventory inventory = new Inventory();

            inventory.setRestaurant(restaurant1);
            inventory.setDescription("kale burger");
            inventory.setNum_available(10);
            inventory.setPrice(10.99);
            inventory.setPrice(10.99);
            inventory.setPickup_start(Time.valueOf("22:00:00"));
            inventory.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory);

            inventory.setRestaurant(restaurant2);
            inventory.setDescription("taco salad");
            inventory.setNum_available(10);
            inventory.setPrice(10.99);
            inventory.setPrice(10.99);
            inventory.setPickup_start(Time.valueOf("22:00:00"));
            inventory.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory);

            inventory.setRestaurant(restaurant3);
            inventory.setDescription("Fish and chips");
            inventory.setNum_available(10);
            inventory.setPrice(10.99);
            inventory.setPrice(10.99);
            inventory.setPickup_start(Time.valueOf("22:00:00"));
            inventory.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory);

            inventory.setRestaurant(restaurant4);
            inventory.setDescription("steak and eggs");
            inventory.setNum_available(10);
            inventory.setPrice(10.99);
            inventory.setPrice(10.99);
            inventory.setPickup_start(Time.valueOf("22:00:00"));
            inventory.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory);

            inventory.setRestaurant(restaurant5);
            inventory.setDescription("tuna melt");
            inventory.setNum_available(10);
            inventory.setPrice(10.99);
            inventory.setPrice(10.99);
            inventory.setPickup_start(Time.valueOf("22:00:00"));
            inventory.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory);



            transaction1.setRestaurant(restaurant1);
            transaction2.setRestaurant(restaurant2);
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
    public List<Transaction> getAllTransactions() {
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
    @GetMapping("/restaurants")
    public void viewRestaurantDetails() {
//        restaurantRepo.findOne(id == ).getId()
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
