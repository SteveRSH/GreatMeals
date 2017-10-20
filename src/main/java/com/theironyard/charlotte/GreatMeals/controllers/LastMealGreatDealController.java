package com.theironyard.charlotte.GreatMeals.controllers;

import com.theironyard.charlotte.GreatMeals.models.database.Inventory;
import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import com.theironyard.charlotte.GreatMeals.models.database.Transaction;
import com.theironyard.charlotte.GreatMeals.models.database.User;
import com.theironyard.charlotte.GreatMeals.models.yelp.Business;
import com.theironyard.charlotte.GreatMeals.repository.InventoryRepository;
import com.theironyard.charlotte.GreatMeals.repository.RestaurantRepository;
import com.theironyard.charlotte.GreatMeals.repository.TransactionRepository;
import com.theironyard.charlotte.GreatMeals.repository.UserRepository;
import com.theironyard.charlotte.GreatMeals.services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

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
        }

//        Restaurant restaurantExists1 = restaurantRepo.findFirstByUsername("lempira-restaurant@lempira.com");
//        Restaurant restaurantExists2 = restaurantRepo.findFirstByUsername("catrachos@catrachos.com");
//        Restaurant restaurantExists3 = restaurantRepo.findFirstByUsername("georges@georges.com");
//        Restaurant restaurantExists4 = restaurantRepo.findFirstByUsername("salad-chick@salad-chick.com");
//        Restaurant restaurantExists5 = restaurantRepo.findFirstByUsername("pollo-campero@campero.com");
//        Restaurant restaurantExists6 = restaurantRepo.findFirstByUsername("rosies-kitchen@rosies.com");
//        Restaurant restaurantExists7 = restaurantRepo.findFirstByUsername("mr-pollo@pollo.com");
//        Restaurant restaurantExists8 = restaurantRepo.findFirstByUsername("roasting-co@roasting.com");
//        Restaurant restaurantExists9 = restaurantRepo.findFirstByUsername("asalad-chick@asalad-chick.com");
//        Restaurant restaurantExists10 = restaurantRepo.findFirstByUsername("johnnys-farmhouse@farmhouse.com");
//        Restaurant restaurantExists11 = restaurantRepo.findFirstByUsername("mr-cs@mcs.com");
//        Restaurant restaurantExists12 = restaurantRepo.findFirstByUsername("chicken-bucket@bucket.com");
//        Restaurant restaurantExists13 = restaurantRepo.findFirstByUsername("el-mariachi@mariachi.com");
//        Restaurant restaurantExists14 = restaurantRepo.findFirstByUsername("dragon-buffett@dragonbuffett.com");
//        Restaurant restaurantExists15 = restaurantRepo.findFirstByUsername("antojitos-catrachos@antojitoscatrachos.com");
//
//
//
//        if (restaurantExists1 == null &&
//                restaurantExists2 == null &&
//                restaurantExists3 == null &&
//                restaurantExists4 == null &&
//                restaurantExists5 == null &&
//                restaurantExists6 == null &&
//                restaurantExists7 == null &&
//                restaurantExists8 == null &&
//                restaurantExists9 == null &&
//                restaurantExists10 == null &&
//                restaurantExists11 == null &&
//                restaurantExists12 == null &&
//                restaurantExists13 == null &&
//                restaurantExists14 == null &&
//                restaurantExists15 == null) {
//            Restaurant restaurant1 = new Restaurant();
//            Restaurant restaurant2 = new Restaurant();
//            Restaurant restaurant3 = new Restaurant();
//            Restaurant restaurant4 = new Restaurant();
//            Restaurant restaurant5 = new Restaurant();
//            Restaurant restaurant6 = new Restaurant();
//            Restaurant restaurant7 = new Restaurant();
//            Restaurant restaurant8 = new Restaurant();
//            Restaurant restaurant9 = new Restaurant();
//            Restaurant restaurant10 = new Restaurant();
//            Restaurant restaurant11 = new Restaurant();
//            Restaurant restaurant12 = new Restaurant();
//            Restaurant restaurant13 = new Restaurant();
//            Restaurant restaurant14 = new Restaurant();
//            Restaurant restaurant15 = new Restaurant();
//
//            restaurant1.setYelp_id("lempira-restaurant-charlotte-3");
//            restaurant1.setUsername("lempira-restaurant@lempira.com");
//            restaurant1.setPassword("12345");
//            restaurantRepo.save(restaurant1);
//
//
//            restaurant2.setYelp_id("antojitos-catrachos-charlotte");
//            restaurant2.setUsername("catrachos@catrachos.com");
//            restaurant2.setPassword("abcde");
//            restaurantRepo.save(restaurant2);
//
//            restaurant3.setYelp_id("georges-brasserie-charlotte");
//            restaurant3.setUsername("georges@georges.com");
//            restaurant3.setPassword("htksit");
//            restaurantRepo.save(restaurant3);
//
//
//            restaurant4.setYelp_id("chicken-salad-chick-charlotte-3");
//            restaurant4.setUsername("salad-chick@salad-chick.com");
//            restaurant4.setPassword("kdowd");
//            restaurantRepo.save(restaurant4);
//
//            restaurant5.setYelp_id("pollo-campero-charlotte");
//            restaurant5.setUsername("pollo-campero@campero.com");
//            restaurant5.setPassword("utllld");
//            restaurantRepo.save(restaurant5);
//
//
//            restaurant6.setYelp_id("rosies-kitchen-charlotte");
//            restaurant6.setUsername("rosies-kitchen@rosies.com");
//            restaurant6.setPassword("8392hd");
//            restaurantRepo.save(restaurant6);
//
//            restaurant7.setYelp_id("mr-pollo-fort-mill");
//            restaurant7.setUsername("mr-pollo@pollo.com");
//            restaurant7.setPassword("84osjb");
//            restaurantRepo.save(restaurant7);
//
//
//            restaurant8.setYelp_id("roasting-co-rock-hill");
//            restaurant8.setUsername("roasting-co@roasting.com");
//            restaurant8.setPassword("w34fht");
//            restaurantRepo.save(restaurant8);
//
//            restaurant9.setYelp_id("chicken-salad-chick-concord");
//            restaurant9.setUsername("asalad-chick@asalad-chick.com");
//            restaurant9.setPassword("u39384");
//            restaurantRepo.save(restaurant9);
//
//            restaurant10.setYelp_id("johnnys-farmhouse-restaurant-concord");
//            restaurant10.setUsername("johnnys-farmhouse@farmhouse.com");
//            restaurant10.setPassword("xdiwfjkf");
//            restaurantRepo.save(restaurant10);
//
//
//            restaurant11.setYelp_id("mr-cs-concord");
//            restaurant11.setUsername("mr-cs@mcs.com");
//            restaurant11.setPassword("keiioan");
//            restaurantRepo.save(restaurant11);
//
//            restaurant12.setYelp_id("chicken-bucket-mount-holly");
//            restaurant12.setUsername("chicken-bucket@bucket.com");
//            restaurant12.setPassword("hejisid");
//            restaurantRepo.save(restaurant12);
//
//
//            restaurant13.setYelp_id("el-mariachi-2-charlotte");
//            restaurant13.setUsername("el-mariachi@mariachi.com");
//            restaurant13.setPassword("833dii");
//            restaurantRepo.save(restaurant13);
//
//            restaurant14.setYelp_id("dragon-buffett-cornelius");
//            restaurant14.setUsername("dragon-buffett@dragonbuffett.com");
//            restaurant14.setPassword("iiisehe");
//            restaurantRepo.save(restaurant14);
//
//
//            restaurant15.setYelp_id("antojitos-catrachos-charlotte");
//            restaurant15.setUsername("antojitos-catrachos@antojitoscatrachos.com");
//            restaurant15.setPassword("ieieidj");
//            restaurantRepo.save(restaurant15);

        // go get all the businesses from Yelp
        List<Business> businesses = YelpService.getSearchResults("food restaurants").getBusinesses();

        // for each business, create a restaurant and save it in our
        // repository
        businesses.forEach(business -> {
            Restaurant r = new Restaurant();

            r.setYelp_id(business.getId());
            r.setUsername(business.getId());
            r.setPassword(String.valueOf(Math.random() * 10000));
            r.setCreated_at(Date.from(Instant.now()));
            r.setDisplay_address(business.getLocation().getDisplay_address().stream().reduce("", (a, b) -> a + b));
            r.setDisplay_phone(business.getDisplay_phone());
            r.setLatitude(business.getCoordinates().getLatitude());
            r.setLongitude(business.getCoordinates().getLongitude());
            r.setImage_url(business.getImage_url());
            r.setName(business.getName());
            r.setPrice(business.getPrice());
            r.setRating((int) business.getRating());

            restaurantRepo.save(r);
        });

        Restaurant restaurantExists1 = restaurantRepo.findFirstByUsername("hi@duckworths.com");
        Restaurant restaurantExists2 = restaurantRepo.findFirstByUsername("hi@seoul.com");
        Restaurant restaurantExists3 = restaurantRepo.findFirstByUsername("hi@roosters.com");
        Restaurant restaurantExists4 = restaurantRepo.findFirstByUsername("hi@kingskitchen.com");
        Restaurant restaurantExists5 = restaurantRepo.findFirstByUsername("hi@dandelionmarket.com");
        Restaurant restaurantExists6 = restaurantRepo.findFirstByUsername("hi@murphys.com");
        Restaurant restaurantExists7 = restaurantRepo.findFirstByUsername("hi@stoke.com");
        Restaurant restaurantExists8 = restaurantRepo.findFirstByUsername("hi@mimosagrill.com");
        Restaurant restaurantExists9 = restaurantRepo.findFirstByUsername("hi@vivachicken.com");
        Restaurant restaurantExists10 = restaurantRepo.findFirstByUsername("hi@alexandermichaels.com");

        if (restaurantExists1 == null &&
                restaurantExists2 == null &&
                restaurantExists3 == null &&
                restaurantExists4 == null &&
                restaurantExists5 == null &&
                restaurantExists6 == null &&
                restaurantExists7 == null &&
                restaurantExists8 == null &&
                restaurantExists9 == null &&
                restaurantExists10 == null) {

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

            restaurant1.setYelp_id("the-cellar-at-duckworths-charlotte-2");
            restaurant1.setUsername("hi@duckworths.com");
            restaurant1.setPassword("12345");
            restaurant1.setDisplay_address("330 N Tryon St\n" + "Charlotte, NC 28202");
            restaurant1.setDisplay_phone("(980) 349-4078");
            restaurant1.setImage_url("https://s3-media1.fl.yelpcdn.com/bphoto/ADgNeipwDFkPYjcdBXS_hA/o.jpg");
            restaurant1.setLatitude(35.22924);
            restaurant1.setLongitude(-80.83971);
            restaurant1.setName("Cellar at Duckworth's");
            restaurant1.setPrice("$$");
            restaurant1.setRating(4.5);
            restaurantRepo.save(restaurant1);


            restaurant2.setYelp_id("seoul-food-meat-company-charlotte");
            restaurant2.setUsername("hi@seoul.com");
            restaurant2.setPassword("abcde");
            restaurant2.setDisplay_address("1400 S Church St\n" + "S2e A\n" + "Charlotte, NC 28203");
            restaurant2.setDisplay_phone("(980) 299-5143");
            restaurant2.setImage_url("https://s3-media3.fl.yelpcdn.com/bphoto/eXvLSXYYqVEsMwvkbQGlrQ/o.jpg");
            restaurant2.setLatitude(35.2192611694336);
            restaurant2.setLongitude(-80.8578567504883);
            restaurant2.setName("Seoul Food Meat Company");
            restaurant2.setPrice("$$");
            restaurant2.setRating(4.0);
            restaurantRepo.save(restaurant2);

            restaurant3.setYelp_id("roosters-uptown-charlotte-5");
            restaurant3.setUsername("hi@roosters.com");
            restaurant3.setPassword("htksit");
            restaurant3.setDisplay_address("150 N College St\n" + "Charlotte, NC 28202");
            restaurant3.setDisplay_phone("(704) 370-7667");
            restaurant3.setImage_url("https://s3-media4.fl.yelpcdn.com/bphoto/fLBfZ1PpakfXZHLxDQkPRA/o.jpg");
            restaurant3.setLatitude(35.2265);
            restaurant3.setLongitude(-80.840796);
            restaurant3.setName("Rooster's Uptown");
            restaurant3.setPrice("$$");
            restaurant3.setRating(4.0);
            restaurantRepo.save(restaurant3);


            restaurant4.setYelp_id("the-kings-kitchen-charlotte");
            restaurant4.setUsername("hi@kingskitchen.com");
            restaurant4.setPassword("kdowd");
            restaurant4.setDisplay_address("129 W Trade St\n" + "Charlotte, NC 28202");
            restaurant4.setDisplay_phone("(704) 375-1990");
            restaurant4.setImage_url("https://s3-media1.fl.yelpcdn.com/bphoto/O9O9Xx28GCswGscVAteSjg/o.jpg");
            restaurant4.setLatitude(35.227757);
            restaurant4.setLongitude(-80.844322);
            restaurant4.setName("The King's Kitchen");
            restaurant4.setPrice("$$");
            restaurant4.setRating(4.0);
            restaurantRepo.save(restaurant4);

            restaurant5.setYelp_id("dandelion-market-charlotte");
            restaurant5.setUsername("hi@dandelionmarket.com");
            restaurant5.setPassword("utllld");
            restaurant5.setDisplay_address("118 W 5th St\n" + "Charlotte, NC 28202");
            restaurant5.setDisplay_phone("(704) 333-7989");
            restaurant5.setImage_url("https://s3-media2.fl.yelpcdn.com/bphoto/t5Kwgi7WiMsDjoIelJjGXw/o.jpg");
            restaurant5.setLatitude(35.2286689);
            restaurant5.setLongitude(-80.84241);
            restaurant5.setName("Dandelion Market");
            restaurant5.setPrice("$$");
            restaurant5.setRating(4.0);
            restaurantRepo.save(restaurant5);


            restaurant6.setYelp_id("murphys-kitchen-and-tap-charlotte-2");
            restaurant6.setUsername("hi@murphys.com");
            restaurant6.setPassword("8392hd");
            restaurant6.setDisplay_address("445 W Trade St\n" + "Charlotte, NC 28202");
            restaurant6.setDisplay_phone("(704) 332-0557");
            restaurant6.setImage_url("https://s3-media4.fl.yelpcdn.com/bphoto/T1fzZ4h-65sdYFwmQterUw/o.jpg");
            restaurant6.setLatitude(35.2302322316856);
            restaurant6.setLongitude(-80.8472118526697);
            restaurant6.setName("Murphy's Kitchen & Tap");
            restaurant6.setPrice("$$");
            restaurant6.setRating(4.5);
            restaurantRepo.save(restaurant6);

            restaurant7.setYelp_id("stoke-charlotte-2\"");
            restaurant7.setUsername("hi@stoke.com");
            restaurant7.setPassword("84osjb");
            restaurant7.setDisplay_address("100 W Trade St\n" + "Charlotte, NC 28202");
            restaurant7.setDisplay_phone("(704) 353-6005");
            restaurant7.setImage_url("https://s3-media1.fl.yelpcdn.com/bphoto/6VaCaUDRRV6tK18TX-WplA/o.jpg");
            restaurant7.setLatitude(35.2273998);
            restaurant7.setLongitude(-80.843064);
            restaurant7.setName("Stoke");
            restaurant7.setPrice("$$");
            restaurant7.setRating(4.0);
            restaurantRepo.save(restaurant7);


            restaurant8.setYelp_id("mimosa-grill-charlotte");
            restaurant8.setUsername("hi@mimosagrill.com");
            restaurant8.setPassword("w34fht");
            restaurant8.setDisplay_address("327 S Tryon St\n" + "Charlotte, NC 28202");
            restaurant8.setDisplay_phone("(704) 343-0700");
            restaurant8.setImage_url("https://s3-media1.fl.yelpcdn.com/bphoto/nqjLi1Rm6EPmvrj01kQyjQ/o.jpg");
            restaurant8.setLatitude(35.22479);
            restaurant8.setLongitude(-80.84528);
            restaurant8.setName("Mimosa Grill");
            restaurant8.setPrice("$$");
            restaurant8.setRating(4.0);
            restaurantRepo.save(restaurant8);

            restaurant9.setYelp_id("viva-chicken-charlotte");
            restaurant9.setUsername("hi@vivachicken.com");
            restaurant9.setPassword("u39384");
            restaurant9.setDisplay_address("1617 Elizabeth Ave\n" + "Charlotte, NC 28204");
            restaurant9.setDisplay_phone("(980) 335-0176");
            restaurant9.setImage_url("https://s3-media4.fl.yelpcdn.com/bphoto/IiiEaNgQ6yfgJdZLT5N7Xg/o.jpg");
            restaurant9.setLatitude(35.2134205994406);
            restaurant9.setLongitude(-80.8260224009839);
            restaurant9.setName("Viva Chicken");
            restaurant9.setPrice("$");
            restaurant9.setRating(4.5);
            restaurantRepo.save(restaurant9);

            restaurant10.setYelp_id("alexander-michaels-charlotte");
            restaurant10.setUsername("hi@alexandermichaels.com");
            restaurant10.setPassword("xdiwfjkf");
            restaurant10.setDisplay_address("401 W 9th St\n" + "Charlotte, NC 28202");
            restaurant10.setDisplay_phone("(704) 332-6789");
            restaurant10.setImage_url("https://s3-media1.fl.yelpcdn.com/bphoto/bw1IaF8FVcmShr6xbE0umA/o.jpg");
            restaurant10.setLatitude(35.23357);
            restaurant10.setLongitude(-80.84083);
            restaurant10.setName("Alexander Michael's");
            restaurant10.setPrice("$$");
            restaurant10.setRating(4.5);
            restaurantRepo.save(restaurant10);

            Inventory inventory1 = new Inventory();
            Inventory inventory2 = new Inventory();
            Inventory inventory3 = new Inventory();
            Inventory inventory4 = new Inventory();
            Inventory inventory5 = new Inventory();
            Inventory inventory6 = new Inventory();
            Inventory inventory7 = new Inventory();
            Inventory inventory8 = new Inventory();
            Inventory inventory9 = new Inventory();
            Inventory inventory10 = new Inventory();

            inventory1.setRestaurant(restaurant1);
            inventory1.setDescription("kale burger");
            inventory1.setNum_available(10);
            inventory1.setPrice(10.99);
            inventory1.setPrice(10.99);
            inventory1.setPickup_start(Time.valueOf("22:00:00"));
            inventory1.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory1);

            inventory2.setRestaurant(restaurant2);
            inventory2.setDescription("taco salad");
            inventory2.setNum_available(10);
            inventory2.setPrice(10.99);
            inventory2.setPrice(10.99);
            inventory2.setPickup_start(Time.valueOf("22:00:00"));
            inventory2.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory2);

            inventory3.setRestaurant(restaurant3);
            inventory3.setDescription("Fish and chips");
            inventory3.setNum_available(10);
            inventory3.setPrice(10.99);
            inventory3.setPrice(10.99);
            inventory3.setPickup_start(Time.valueOf("22:00:00"));
            inventory3.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory3);

            inventory4.setRestaurant(restaurant4);
            inventory4.setDescription("steak and eggs");
            inventory4.setNum_available(10);
            inventory4.setPrice(10.99);
            inventory4.setPrice(10.99);
            inventory4.setPickup_start(Time.valueOf("22:00:00"));
            inventory4.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory4);

            inventory5.setRestaurant(restaurant5);
            inventory5.setDescription("sesame chicken");
            inventory5.setNum_available(10);
            inventory5.setPrice(10.99);
            inventory5.setPrice(10.99);
            inventory5.setPickup_start(Time.valueOf("22:00:00"));
            inventory5.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory5);

            inventory6.setRestaurant(restaurant6);
            inventory6.setDescription("grilled beef and broccoli");
            inventory6.setNum_available(10);
            inventory6.setPrice(10.99);
            inventory6.setPrice(10.99);
            inventory6.setPickup_start(Time.valueOf("22:00:00"));
            inventory6.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory6);

            inventory7.setRestaurant(restaurant7);
            inventory7.setDescription("Taco burger");
            inventory7.setNum_available(10);
            inventory7.setPrice(10.99);
            inventory7.setPrice(10.99);
            inventory7.setPickup_start(Time.valueOf("22:00:00"));
            inventory7.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory7);

            inventory8.setRestaurant(restaurant8);
            inventory8.setDescription("Asian salad");
            inventory8.setNum_available(10);
            inventory8.setPrice(10.99);
            inventory8.setPrice(10.99);
            inventory8.setPickup_start(Time.valueOf("22:00:00"));
            inventory8.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory8);

            inventory9.setRestaurant(restaurant9);
            inventory9.setDescription("Grilled cheese sandwich");
            inventory9.setNum_available(10);
            inventory9.setPrice(10.99);
            inventory9.setPrice(10.99);
            inventory9.setPickup_start(Time.valueOf("22:00:00"));
            inventory9.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory9);


            inventory10.setRestaurant(restaurant10);
            inventory10.setDescription("Almond batter nuggets");
            inventory10.setNum_available(10);
            inventory10.setPrice(10.99);
            inventory10.setPrice(10.99);
            inventory10.setPickup_start(Time.valueOf("22:00:00"));
            inventory10.setPickup_end(Time.valueOf("00:00:00"));
            inventoryRepo.save(inventory10);


            transaction1.setRestaurant(restaurant1);
            transaction2.setRestaurant(restaurant2);
            transaction1.setUser(user);
            transaction2.setUser(user);
            transactionRepo.save(tranSet);
        }
    }

//        Inventory inventoryExists = inventoryRepo.findFirstByRestaurant(restaurant);



    //********* NON SPECIFIC CONTROLLERS START HERE *******//

//TODO: Sessions -- discuss with Ben
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

    //*************************************************//


    //********* RESTAURANT-SIDE SPECIFIC CONTROLLERS START HERE *******//\

    @CrossOrigin
    @GetMapping("/inventory/{restaurant_id}")
    public List<Inventory> getAllInventory(
            @PathVariable("restaurant_id") int restaurant_id) {

        List<Inventory> allInventory = inventoryRepo.findAllByRestaurantId(restaurant_id);

        return allInventory;
    }


    @CrossOrigin
    @PostMapping("/inventory/{restaurant_id}")
    public void addInventory(
            @PathVariable("restaurant_id") int restaurant_id,
            @RequestBody Inventory item) {
        item.setRestaurant(restaurantRepo.findRestaurantById(restaurant_id));
        inventoryRepo.save(item);
    }

    @CrossOrigin
    @DeleteMapping("/inventory/{itemId}")
    public void deleteFromInventory(
            @PathVariable("itemId") int id) {

        Inventory item = inventoryRepo.findOne(id);
        inventoryRepo.delete(item);
    }

    @CrossOrigin
    @PostMapping("/inventory/{itemId}")
    public void editInventoryItem(
            @PathVariable("itemId") int id,
            @RequestBody Inventory item) {

        item.setRestaurant(restaurantRepo.findOne(id));
        inventoryRepo.save(item);
    }

    @CrossOrigin
    @GetMapping("/transactions/{restaurant_id}")
    public List<Transaction> getAllTransactions(
            @PathVariable("restaurant_id") int restaurant_id) {

        List<Transaction> allTransactions = transactionRepo.findAllByRestaurantId(restaurant_id);

        return allTransactions;
    }


//TODO: EXTRAS with SORT and SEARCH
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

    //********* CUSTOMER-SIDE SPECIFIC CONTROLLERS START HERE *******//

    @CrossOrigin
    @GetMapping("/restaurants/{restaurant_id}")
    public Restaurant getRestaurantDetails(
            @PathVariable("restaurant_id") int restaurant_id) {

        Restaurant restaurant = restaurantRepo.findOne(restaurant_id);

        return restaurant;
    }

//TODO: how to return all restaurants within certain longitude and latitude limits? Discuss with Ben.
    // /restaurants?lat=<blah>&lng=<blah>
//    @CrossOrigin
//    @GetMapping("/restaurants")
//    public List<Restaurant> getAllRestaurants(
//            @RequestParam(value = "lat") String lat,
//            @RequestParam(value = "lng") String lng) {
//
//        final double radius = .5;
//
//        List<Restaurant> allRestaurantsInArea = (List<Restaurant>)restaurantRepo.findAll();
//
//        return allRestaurantsInArea
//                .stream()
//                .filter(r -> distanceBetweenCoords(lat, lng, r.getLatitude(), r.getLongitude()) < radius)
//                .collect(Collectors.toList());
//    }


//TODO: I think we have to create a new database and separate controller for carts.
//TODO: We will need to do research on this. Discuss with Ben.
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

//TODO: For the confirmation page (the one that comes immediately after they make a
//TODO: purchase) -- we need to think through whether we really need a separate
//TODO: endpoint for this.  What we can do is, create an application response
//TODO: (to the purchase endpoint) as a JSON object that they can display on their page.
//    @CrossOrigin
//    @GetMapping("/customer/restaurants/transactions")
//    public void confirmation() {
//        //return all restaurants in area
//    }


//TODO: EXTRAS with SORT and SEARCH
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
    //*************************************************//
}
