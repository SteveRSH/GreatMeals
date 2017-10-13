package com.theironyard.charlotte.GreatMeals.models;

import org.springframework.cglib.core.Local;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    LocalBusiness business;

    @Column
    UserType userType;
}
