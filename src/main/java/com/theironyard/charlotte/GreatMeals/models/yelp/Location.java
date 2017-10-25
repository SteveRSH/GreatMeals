package com.theironyard.charlotte.GreatMeals.models.yelp;

import java.util.ArrayList;

///endpoints added to return businesses based on the provided search criteria

public class Location {
    public String address1;
    public String address2;
    public String address3;
    public String city;
    public String zip_code;
    public String US;
    public String state;
    public ArrayList<String> display_address;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getUS() {
        return US;
    }

    public void setUS(String US) {
        this.US = US;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<String> getDisplay_address() {
        return display_address;
    }

    public void setDisplay_address(ArrayList<String> display_address) {
        this.display_address = display_address;
    }

    @Override
    public String toString() {
        return "YelpLocation{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", city='" + city + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", US='" + US + '\'' +
                ", state='" + state + '\'' +
                ", display_address='" + display_address + '\'' +
                '}';
    }

    public Location() {
    }
}