package com.theironyard.charlotte.GreatMeals.repository;

import com.theironyard.charlotte.GreatMeals.models.database.Inventory;
import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository
    extends CrudRepository<Inventory, Integer> {

    Inventory findFirstByRestaurant(Restaurant restaurant);
    Inventory findFirstById(int id);
}
