package com.theironyard.charlotte.GreatMeals.repository;

import com.theironyard.charlotte.GreatMeals.models.database.Inventory;
import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository
        extends CrudRepository<Restaurant, Integer> {

    Restaurant findFirstByUsername(String username);
    Restaurant findRestaurantById(int id);
    Restaurant findFirstByUsernameAndPassword(String username, String password);
}
