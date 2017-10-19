package com.theironyard.charlotte.GreatMeals.models.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


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
 *
 *          ]
 *     }
 * }
 */

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String yelp_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int rating;

    @Column
    private String image_url;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private String display_address;

    @Column(nullable = false)
    private String display_phone;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    
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

    public String getYelp_id() {
        return yelp_id;
    }

    public void setYelp_id(String yelp_id) {
        this.yelp_id = yelp_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
