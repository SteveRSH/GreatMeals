package com.theironyard.charlotte.GreatMeals.repository;

import com.theironyard.charlotte.GreatMeals.models.database.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository
        extends CrudRepository<Transaction, Integer> {
}
