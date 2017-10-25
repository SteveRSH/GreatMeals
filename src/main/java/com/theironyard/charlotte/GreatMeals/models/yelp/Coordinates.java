package com.theironyard.charlotte.GreatMeals.models.yelp;

//added to return businesses based on the latitude and longitude

public class Coordinates {
    public double latitude;
    public double longitude;

    public Coordinates() {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}