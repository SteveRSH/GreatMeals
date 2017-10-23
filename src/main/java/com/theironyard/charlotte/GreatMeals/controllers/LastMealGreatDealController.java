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
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.sql.Time;
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

        //********* CREATING DUMMY DATABASE ITEMS *******//
        Transaction transaction1 = new Transaction();
        transaction1.setTotal(132.50);
        Transaction transaction2 = new Transaction();
        transaction2.setTotal(100.50);

        transactionRepo.save(transaction1);
        transactionRepo.save(transaction2);

        User userExists = userRepo.findFirstByUsername("test@test.com");
        User user = new User();

        if (userExists == null) {
            user.setUsername("test@test.com");
            user.setPassword("test");
            userRepo.save(user);
        }

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

            //Instantiating new restaurants...
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


            //Instantiating new inventory items...
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

            List<Inventory> list = Arrays.asList(inventory10);

            //Setting all the values...
            inventory10.setDescription("Almond batter nuggets");
            inventory10.setNum_available(10);
            inventory10.setPrice(10.99);
            inventory10.setPrice(10.99);
            inventory10.setPickup_start(Time.valueOf("22:00:00"));
            inventory10.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant1.setInventory(list);

            //Note on weird ordering: had to do it this way to get them all saved to the database.
            inventory10.setRestaurant(restaurant1);
            restaurantRepo.save(restaurant1);

            //I create a new list for every inventory instance. Then I change the value of list so that it points to
            //different objects in memory.
            list = Arrays.asList(inventory9);

            inventory9.setDescription("Grilled cheese sandwich");
            inventory9.setNum_available(10);
            inventory9.setPrice(10.99);
            inventory9.setPrice(10.99);
            inventory9.setPickup_start(Time.valueOf("22:00:00"));
            inventory9.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant2.setInventory(list);

            inventory9.setRestaurant(restaurant2);
            restaurantRepo.save(restaurant2);
            list = Arrays.asList(inventory8);

            inventory8.setDescription("Asian salad");
            inventory8.setNum_available(10);
            inventory8.setPrice(10.99);
            inventory8.setPrice(10.99);
            inventory8.setPickup_start(Time.valueOf("22:00:00"));
            inventory8.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant3.setInventory(list);

            inventory8.setRestaurant(restaurant3);
            restaurantRepo.save(restaurant3);
            list = Arrays.asList(inventory7);

            inventory7.setDescription("Taco burger");
            inventory7.setNum_available(10);
            inventory7.setPrice(10.99);
            inventory7.setPrice(10.99);
            inventory7.setPickup_start(Time.valueOf("22:00:00"));
            inventory7.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant4.setInventory(list);

            inventory7.setRestaurant(restaurant4);
            restaurantRepo.save(restaurant4);
            list = Arrays.asList(inventory6);

            inventory6.setDescription("grilled beef and broccoli");
            inventory6.setNum_available(10);
            inventory6.setPrice(10.99);
            inventory6.setPrice(10.99);
            inventory6.setPickup_start(Time.valueOf("22:00:00"));
            inventory6.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant5.setInventory(list);

            inventory6.setRestaurant(restaurant5);
            restaurantRepo.save(restaurant5);
            list = Arrays.asList(inventory5);

            inventory5.setDescription("sesame chicken");
            inventory5.setNum_available(10);
            inventory5.setPrice(10.99);
            inventory5.setPrice(10.99);
            inventory5.setPickup_start(Time.valueOf("22:00:00"));
            inventory5.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant6.setInventory(list);

            inventory5.setRestaurant(restaurant6);
            restaurantRepo.save(restaurant6);
            list = Arrays.asList(inventory4);

            inventory4.setDescription("steak and eggs");
            inventory4.setNum_available(10);
            inventory4.setPrice(10.99);
            inventory4.setPrice(10.99);
            inventory4.setPickup_start(Time.valueOf("22:00:00"));
            inventory4.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant7.setInventory(list);

            inventory4.setRestaurant(restaurant7);
            restaurantRepo.save(restaurant7);
            list = Arrays.asList(inventory3);

            inventory3.setDescription("Fish and chips");
            inventory3.setNum_available(10);
            inventory3.setPrice(10.99);
            inventory3.setPrice(10.99);
            inventory3.setPickup_start(Time.valueOf("22:00:00"));
            inventory3.setPickup_end(Time.valueOf("00:00:00"));
            inventory3.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant8.setInventory(list);

            inventory3.setRestaurant(restaurant8);
            restaurantRepo.save(restaurant8);
            list = Arrays.asList(inventory2);

            inventory2.setDescription("taco salad");
            inventory2.setNum_available(10);
            inventory2.setPrice(10.99);
            inventory2.setPrice(10.99);
            inventory2.setPickup_start(Time.valueOf("22:00:00"));
            inventory2.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant9.setInventory(list);

            inventory2.setRestaurant(restaurant9);
            restaurantRepo.save(restaurant9);
            list = Arrays.asList(inventory1);

            inventory1.setDescription("kale burger");
            inventory1.setNum_available(10);
            inventory1.setPrice(10.99);
            inventory1.setPrice(10.99);
            inventory1.setPickup_start(Time.valueOf("22:00:00"));
            inventory1.setPickup_end(Time.valueOf("00:00:00"));

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
            restaurant10.setInventory(list);

            inventory1.setRestaurant(restaurant10);
            restaurantRepo.save(restaurant10);

            transaction1.setRestaurant(restaurant1);
            transaction2.setRestaurant(restaurant2);
            transaction1.setUser(user);
            transaction2.setUser(user);

            transactionRepo.save(transaction1);
            transactionRepo.save(transaction2);
        }
    }
    //*************************************************//

    //This is a general method for both customer and restaurant side signout.
    @CrossOrigin
    @PostMapping("/signout")
    public void signout(HttpSession session) {

        //session.invalidate() is how you "destroy" sessions in Spring
        if(session != null) { session.invalidate(); }
    }

    //********* RESTAURANT-SIDE SPECIFIC CONTROLLERS START HERE *******//

    @CrossOrigin
    @PostMapping("/restaurant-signin")
    public void restaurantSignIn(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {
        Restaurant user = restaurantRepo
                .findFirstByUsernameAndPassword(username, password);

        if (user != null) {
            session.setAttribute("current_restaurant_user", user.getId());
        }
    }

    @CrossOrigin
    @GetMapping("/inventory")
    public List<Inventory> getInventory (HttpSession session) {
        if (session.getAttribute("current_restaurant_user") != null) {
            int rest_id = (Integer) session.getAttribute("current_restaurant_user");

            //Find the specific restaurant, create a list of that restaurant's inventory
            Restaurant restaurant = restaurantRepo.findOne(rest_id);
            List<Inventory> listOfThings = restaurant.getInventory();

            //This is just another way to iterate through a list of things
            //Basically, while there is still items on the list,
            //if the num_available is == 0, then remove it from the list. Return the list.
            Iterator<Inventory> i = listOfThings.iterator();
            while (i.hasNext()) {
                Inventory thing = i.next(); // must be called before you can call i.remove()
                if (thing.getNum_available() == 0) {
                    i.remove();
                }
            }
            return listOfThings;
        }
        return null;
    }


    @CrossOrigin
    @PostMapping("/inventory")
    public void addInventory(
            HttpSession session,
            @RequestBody Inventory item) {
        if (session.getAttribute("current_restaurant_user") != null) {

            //the sessionAttribute returns an Object; we need to explicitly set it to an Integer in order to use it.
            int rest_id = (Integer) session.getAttribute("current_restaurant_user");
            Restaurant restaurant = restaurantRepo.findOne(rest_id);

            item.setRestaurant(restaurant);
            inventoryRepo.save(item);

            List<Inventory> inventory = restaurant.getInventory();
            inventory.add(item);
            restaurant.setInventory(inventory);
            restaurantRepo.save(restaurant);
        }
    }



    @CrossOrigin
    @DeleteMapping("/inventory/{inventoryId}")
    public void deleteFromInventory(
            @PathVariable ("inventoryId") int inventoryId,
            HttpSession session) {

        //Set availability to 0 instead of deleting from DB because of 1) key constraints 2) you're not supposed
        //to be deleting things from the database anyway :) The GET all inventory method will return only items with
        //availability > 0.
        if (session.getAttribute("current_restaurant_user") != null) {
            Inventory thing = inventoryRepo.findOne(inventoryId);
            Restaurant restaurant = thing.getRestaurant();
            int rest_id = (Integer) session.getAttribute("current_restaurant_user");

            if (rest_id == restaurant.getId()) {
                thing.setNum_available(0);
                inventoryRepo.save(thing);
            }

        }
    }

    @CrossOrigin
    @PostMapping("/inventory/{inventoryId}")
    public void editInventoryItem(
            @PathVariable("inventoryId") int inventoryId,
            HttpSession session) {
        if (session.getAttribute("current_restaurant_user") != null) {
            Inventory thing = inventoryRepo.findOne(inventoryId);
            Restaurant restaurant = thing.getRestaurant();
            int rest_id = (Integer) session.getAttribute("current_restaurant_user");

            if (rest_id == restaurant.getId()) {
                inventoryRepo.save(thing);
            }
        }
    }

    @CrossOrigin
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(HttpSession session) {
        if (session.getAttribute("current_restaurant_user") != null) {
            int rest_id = (Integer) session.getAttribute("current_restaurant_user");
            List<Transaction> transactions = transactionRepo.findAllByRestaurantId(rest_id);
            return transactions;
        }
        return null;
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
    @PostMapping("/customer-signin")
    public void customerSignIn(
            //TODO: Possibly change this to parse JSON instead of form input, same with restaurant
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {
        User user = userRepo
                .findFirstByUsernameAndPassword(username, password);
        System.out.println(username);
        System.out.println(password);
        if (user != null) {
            session.setAttribute("current_customer_user", user.getId());
            System.out.println("poo");
        }
    }

    @CrossOrigin
    @GetMapping("/restaurant/{restaurant_id}")
    public Restaurant getRestaurantDetails(
            @PathVariable("restaurant_id") int restaurant_id,
            HttpSession session) {
        //TODO: Sooooo this will return the restaurant's username and password as well. We need to figure out how to
        //TODO: not do that... but not important for minimum viable product.
        if (session.getAttribute("current_customer_user") != null) {

            Restaurant restaurant = restaurantRepo.findOne(restaurant_id);
            return restaurant;
        }
        return null;
    }

    //To search for all restaurants within certain distance of the user, use pythagorean theorem.
    public double distanceBetweenCoords(double lat1, double lng1, double lat2, double lng2) {
        double a = lat1 - lat2;
        double b = lng1 - lng2;
        double c = Math.sqrt(a*a + b*b);

        return c;
    }

    @CrossOrigin
    @GetMapping("/restaurants")
    // /restaurants?lat=<blah>&lng=<blah>
    public List<Restaurant> getAllRestaurants(
            @RequestParam(value = "lat") double lat,
            @RequestParam(value = "lng") double lng,
            HttpSession session) {

        //TODO: verify math works
        final double radius = .5;

        if (session.getAttribute("current_customer_user") != null) {
            List<Restaurant> allRestaurantsInArea = (List<Restaurant>) restaurantRepo.findAll();

            return allRestaurantsInArea
                    .stream()
                    .filter(r -> distanceBetweenCoords(lat, lng, r.getLatitude(), r.getLongitude()) < radius)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @CrossOrigin
    @PostMapping("/cart")
    public List<Inventory> addToCart(
            @RequestParam(value = "inventoryId") int inventoryId,
            @RequestParam(value = "quantity") int quantity,
            HttpSession session) {

        List<Inventory> cart = new ArrayList<Inventory>();
        if (session.getAttribute("current_customer_user") != null) {

            //if the session doesnt have a cart already, add a cart.
            if (session.getAttribute("cart") == null) {
                session.setAttribute("cart", cart);
            }

            //if we don't explicitly set cart to the session, inventory items will be saved to the list "cart" but
            //not the session.
            cart = (List<Inventory>) session.getAttribute("cart");

            Inventory item = inventoryRepo.findOne(inventoryId);
            if (quantity <= item.getNum_available() && quantity > 0) {
                //we're using num_available to represent the quantity in the cart.
                item.setNum_available(quantity);
                cart.add(item);
            } else if (quantity == 0) {
                cart.remove(item);
            } else {
                    //if I want 8 hotdogs and I only have 6, it will give me 6 -- the max amount available.
                    cart.add(item);
                }
            }

        //this is to update our cart in session. if you look above, we never set cart to session IF the
        //cart already exists.
        session.setAttribute("cart", cart);
        return cart;
    }

    //TODO: Tested on Postman and it hangs... Not sure why not returning either empty or full cart. Ask Ben.
    @CrossOrigin
    @GetMapping("/cart")
    public List<Inventory> getAllStuffInCart(HttpSession session) {
        List<Inventory> cart = new ArrayList<Inventory>();
        if (session.getAttribute("current_customer_user") != null) {
             cart = (List<Inventory>) session.getAttribute("cart");
        }
        return cart;
    }

    @CrossOrigin
    @PostMapping("/pay")
    public Transaction payForFood(
            //Front end shouldn't have to pass anything for this to work? As long as total bill is more than $0.
            Transaction transaction,
            HttpSession session) {
        if (session.getAttribute("current_customer_user") != null) {
            System.out.println("Hi im here");

            //Assign the session's cart to a variable that we can process
            List<Inventory> cart = (List<Inventory>) session.getAttribute("cart");
            double totalBill = 0;

            //For all items in the session cart, add price* quantity to the total bill
            for (Inventory cartItems : cart) {
                System.out.println("I've got money. Honey. ");
                totalBill += (cartItems.getPrice()*cartItems.getNum_available());
            }

            if (transaction.processCard(totalBill)) {
                System.out.println("CC ind a house");
                for (Inventory stuffInCart : cart) {
                    System.out.println("hi");
                    Inventory tempObject = inventoryRepo.findOne(stuffInCart.getId());

                    //set the num_available for object in database to ... whats left
                    tempObject.setNum_available(tempObject.getNum_available()-stuffInCart.getNum_available());
                    inventoryRepo.save(tempObject);
                }

                //set transaction details to session owner (user) and to restaurant
                transaction.setUser(userRepo.findOne((Integer) session.getAttribute("current_customer_user")));

                int tempId = cart.get(0).getId();
                Inventory tempInventory = inventoryRepo.findOne(tempId);
                Restaurant restaurant = tempInventory.getRestaurant();
                transaction.setRestaurant(restaurant);
                transaction.setTotal(totalBill);

                //TODO: This is having trouble serializing the java object into JSON and I'm too sleepy to
                //TODO: figure out why. Ask Ben
                transactionRepo.save(transaction);
                session.removeAttribute("cart");

                return transaction;
            }
        }
        return null;
    }


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
