package com.theironyard.charlotte.GreatMeals.models.database;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * {
 *     "id": 1,
 *     "description": "Best shit in town. NO doubt.",
 *     "price": 4.55,
 *     "restaurant": {
 *
 *     }
 * }
 *
 * {
 *     "description": string,
 *     "price": double,
 *     "num_available: int,
 *     "pickup_start": time (e.g. 10:00:00),
 *     "pickup_end": time (e.g. 10:00:00),
 *     "created_at": date time (e.g. 10-20-2017T10:00:00)
 * }
 */
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int num_available;

    @Column
    private Time pickup_start;

    @Column
    private Time pickup_end;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum_available() {
        return num_available;
    }

    public void setNum_available(int num_available) {
        this.num_available = num_available;
    }

    public Time getPickup_start() {
        return pickup_start;
    }

    public void setPickup_start(Time pickup_start) {
        this.pickup_start = pickup_start;
    }

    public Time getPickup_end() {
        return pickup_end;
    }

    public void setPickup_end(Time pickup_end) {
        this.pickup_end = pickup_end;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
