package com.theironyard.charlotte.GreatMeals.services;

import com.theironyard.charlotte.GreatMeals.models.yelp.Business;
import com.theironyard.charlotte.GreatMeals.models.yelp.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class YelpService {
    private static final String AUTHTOKEN = "Bearer ze16p9aetTdlbCkdM4p2cOb2i9B-Dgt8JJkxkzs7Nyt4FKSrN8l5Jmkz_TJP28iW3XG-jm8z1z2peHpLYWjSC6kcd5Nw3ceB3QdAg1n7z_dIZHf6JulyHM-GfU3eWXYx";

    public static Response getSearchResults(String query) {
        RestTemplate template = new RestTemplate();
        String url =
                "https://api.yelp.com/v3/businesses/search?term=" + query + "&latitude=35.227263199999996&longitude=-80.8465059";
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, AUTHTOKEN);
        HttpEntity<String> request = new HttpEntity<>(headers);
        Response restaurantList = template.exchange(url, HttpMethod.GET, request, Response.class).getBody();

        return restaurantList;
    }
}
