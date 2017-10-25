package com.theironyard.charlotte.GreatMeals.models.yelp;

import java.util.ArrayList;

//Yelp API - allows the user to access various info (e.g. restaurant name, ratings, location)

public class Business {
    public String id;
    public String name;
    public String image_url;
    public boolean is_closed;
    public int review_count;
    public ArrayList<Category> categories;
    public double rating;
    public Coordinates coordinates;
    public ArrayList<String> transactions;
    public String price;
    public Location location;
    public String phone;
    public String display_phone;
    public double distance;


    public Business() {
    }

    @Override
    public String toString() {
        return "Business{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", is_closed='" + is_closed + '\'' +
                ", review_count=" + review_count +
                ", categories=" + categories +
                ", rating=" + rating +
                ", coordinates=" + coordinates +
                ", transactions=" + transactions +
                ", price=" + price +
                ", location=" + location +
                ", phone='" + phone + '\'' +
                ", display_phone=" + display_phone +
                ", distance=" + distance +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplay_phone() {
        return display_phone;
    }

    public void setDisplay_phone(String display_phone) {
        this.display_phone = display_phone;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}