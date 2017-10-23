package com.theironyard.charlotte.GreatMeals.repository;

import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import com.theironyard.charlotte.GreatMeals.models.database.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, Integer> {

    User findFirstByUsername(String username);
    User findFirstByUsernameAndPassword(String username, String password);
}
