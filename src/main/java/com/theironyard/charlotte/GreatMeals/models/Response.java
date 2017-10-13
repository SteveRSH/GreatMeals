package com.theironyard.charlotte.GreatMeals.models;

import java.util.List;

public class Response {
    public List<Business> restaurantBusiness;
    public int total;

    public List<Business> getRestuarantBusiness() {
        return restaurantBusiness;
    }

    public void setRestaurantBusiness(List<Business> restaurantBusiness) {
        this.restaurantBusiness = restaurantBusiness;
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
                "restaurantBusiness=" + restaurantBusiness +
                ", total=" + total +
                '}';
    }

    public Response() {


    }
}
