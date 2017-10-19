package com.theironyard.charlotte.GreatMeals.repository;

import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository
        extends CrudRepository<Restaurant, Integer> {

    Restaurant findFirstByUsername(String username);
}
