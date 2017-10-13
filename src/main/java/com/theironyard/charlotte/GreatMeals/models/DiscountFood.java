package com.theironyard.charlotte.GreatMeals.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "DiscountFoods")
public class DiscountFood {
    @Column
    public double prices;

    @Column
    public Date available;

    @ManyToOne
    LocalBusiness business;

    @Column
    public String names;

    @Id
    @GeneratedValue
    private int id;

    public DiscountFood() {
    }

    public DiscountFood(double prices, Date available, LocalBusiness business, String names, int id) {
        this.prices = prices;
        this.available = available;
        this.business = business;
        this.names = names;
        this.id = id;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public Date getAvailable() {
        return available;
    }

    public void setAvailable(Date available) {
        this.available = available;
    }

    public LocalBusiness getBusiness() {
        return business;
    }

    public void setBusiness(LocalBusiness business) {
        this.business = business;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DiscountFood{" +
                "prices=" + prices +
                ", available=" + available +
                ", business=" + business +
                ", names=" + names +
                ", id=" + id +
                '}';
    }
}
