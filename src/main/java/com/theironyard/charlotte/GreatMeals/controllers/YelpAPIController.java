package com.theironyard.charlotte.GreatMeals.controllers;

import com.theironyard.charlotte.GreatMeals.models.LocalBusiness;
import com.theironyard.charlotte.GreatMeals.models.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class YelpAPIController {
    private static final String AUTHTOKEN = "Bearer ze16p9aetTdlbCkdM4p2cOb2i9B-Dgt8JJkxkzs7Nyt4FKSrN8l5Jmkz_TJP28iW3XG-jm8z1z2peHpLYWjSC6kcd5Nw3ceB3QdAg1n7z_dIZHf6JulyHM-GfU3eWXYx";

    @CrossOrigin
    @PostMapping(path = "/search") //temp path to just make it work
    private Response searchTest(){
        RestTemplate template = new RestTemplate();
        String url = "https://api.yelp.com/v3/businesses/search?term=delis&latitude=37.786882&longitude=-122.399972";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, AUTHTOKEN);

        HttpEntity<String> request = new HttpEntity<>(headers);

        Response restuarantList = template.exchange(url, HttpMethod.GET, request, Response.class).getBody();

        return restuarantList;

    }

    @CrossOrigin
    @GetMapping("/get-businesses")
    public List<LocalBusiness> getBusinesses() {
        List<LocalBusiness> businesses = new ArrayList<>();

        LocalBusiness lb = new LocalBusiness("Papa John's", "Pizza", "Charlotte", -80.84217129999999, 35.2266289);
        businesses.add(lb);

        lb = new LocalBusiness("Whole Foods", "Varies", "Charleston", -80.84546999999999, 35.224456);
        businesses.add(lb);

        lb = new LocalBusiness("McDonalds", "Burgers", "Myers Park", -80.8430209, 35.2287917);
        businesses.add(lb);

        lb = new LocalBusiness("Burbon Street", "Fish and Chips", "Fort Mills", -80.843726,  35.225338);
        businesses.add(lb);

        lb = new LocalBusiness("Sushi House", "Sushi", "Plaze Midwood", -80.8410287, 35.2245326);
        businesses.add(lb);


        return businesses;
    }
}

