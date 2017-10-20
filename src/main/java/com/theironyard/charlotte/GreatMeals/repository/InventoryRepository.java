package com.theironyard.charlotte.GreatMeals.repository;

import com.theironyard.charlotte.GreatMeals.models.database.Inventory;
import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository
    extends CrudRepository<Inventory, Integer> {

    Inventory findFirstByDescription(String description);
}
