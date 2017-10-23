package com.theironyard.charlotte.GreatMeals.models.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * {
 *     "id": 1,
 *     "description": "Best shit in town. NO doubt.",
 *     "price": 4.55,
 *     "restaurant": {
 *          "id": 42,
 *          "yelp_id": "abcdef",
 *          "username": "Ben",
 *          "password": "password",
 *          "transactions": [
 *              {
 *                  "id": 350,
 *
*               }
 *
 *          ]
 *     }
 * }
 */

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    User user;

    @ManyToOne
    Restaurant restaurant;

    @Column(nullable = false)
    private double total;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    //This is a dummy method that will always return true when we process a credit card... Will have to change
    //obviously once we actually process cards.
    public boolean processCard(double totalBill) {
        if (totalBill >= 0) { return true; }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
