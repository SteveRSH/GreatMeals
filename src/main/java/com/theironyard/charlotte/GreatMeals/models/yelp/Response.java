package com.theironyard.charlotte.GreatMeals.models.yelp;

import java.util.List;

public class Response {
    public List<Business> businesses;
    public int total;

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Response{" +
                "businesses=" + businesses +
                ", total=" + total +
                '}';
    }

    public Response() {


    }
}