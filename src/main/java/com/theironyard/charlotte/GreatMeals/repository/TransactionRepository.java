package com.theironyard.charlotte.GreatMeals.repository;

import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import com.theironyard.charlotte.GreatMeals.models.database.Transaction;
import com.theironyard.charlotte.GreatMeals.models.database.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository
        extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByUser(User u);

    List<Transaction> findAllByRestaurantId(int restaurant_id);
}
