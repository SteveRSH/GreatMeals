package com.theironyard.charlotte.GreatMeals.models.database;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    Restaurant restaurant;

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

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;
}
