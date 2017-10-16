package com.theironyard.charlotte.GreatMeals.models.yelp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "local_business")
public class LocalBusiness {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(nullable = false)
   private String businessName;

    @Column(nullable = false)
    private String category;

    @OneToMany
    List<DiscountFood> foods;

    @Column(nullable = false)
    public String location;

    @Column(nullable = false)
    public double latitude;

    @Column(nullable = false)
    public double longitude;

    public LocalBusiness(){
    }

    public LocalBusiness(String businessName, String category, String location, double longitude, double latitude){
        this.businessName = businessName;
        this.category = category;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<DiscountFood> getFoods() {
        return foods;
    }

    public void setFoods(List<DiscountFood> foods) {
        this.foods = foods;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {return latitude; }

    public void setLatitude(double latitude) {this.latitude = latitude; }

    public double getLongitude() {return longitude; }

    public void setLongitude(double longitude) {this.longitude = longitude; }

    @Override
    public String toString() {
        return "LocalBusiness{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                ", category='" + category + '\'' +
                ", foods=" + foods +
                ", location='" + location + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public void setLocation(String location) {
        this.location = location;


    }
}
