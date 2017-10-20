package com.theironyard.charlotte.GreatMeals.models;

import com.theironyard.charlotte.GreatMeals.models.database.Inventory;
import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;

import java.util.List;

public class RestaurantInventoryWrapper {
    private List<Inventory> inventory;
    private Restaurant restaurant;

    public RestaurantInventoryWrapper(List<Inventory> inventory, Restaurant restaurant) {
        this.inventory = inventory;
        this.restaurant = restaurant;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
