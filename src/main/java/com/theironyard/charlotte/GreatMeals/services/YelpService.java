package com.theironyard.charlotte.GreatMeals.services;

import com.theironyard.charlotte.GreatMeals.models.database.Restaurant;
import com.theironyard.charlotte.GreatMeals.models.yelp.Business;
import com.theironyard.charlotte.GreatMeals.models.yelp.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;

//This endpoint returns the detail information of a business
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


        // made a rest template request
        // to get the details for an individual business.
        // once you get the business, convert it to a restaurant and return
        // the restaurant

        public static Restaurant getSingleBusinessAsRestaurant(String yelpId) {
        RestTemplate template = new RestTemplate();
        String url =
                "https://api.yelp.com/v3/businesses/" + yelpId;
            System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, AUTHTOKEN);
        HttpEntity<String> request = new HttpEntity<>(headers);
        try {
            Business individualBusiness = template.exchange(url, HttpMethod.GET, request, Business.class).getBody();
            Business business = template.exchange(url, HttpMethod.GET, request, Business.class).getBody();
            Restaurant r = new Restaurant();

            r.setPrice(individualBusiness.getPrice());
            r.setYelp_id(business.getId());
            r.setDisplay_phone(business.getDisplay_phone());
            r.setUsername(business.getId());
            r.setPassword(String.valueOf(Math.random() * 10000));
            r.setDisplay_address(business.getLocation().getDisplay_address().stream().reduce("", (a, b) -> a + b));
            r.setDisplay_phone(business.getDisplay_phone());
            r.setLatitude(business.getCoordinates().getLatitude());
            r.setLongitude(business.getCoordinates().getLongitude());
            r.setImage_url(business.getImage_url());
            r.setName(business.getName());
            r.setPrice(business.getPrice());
            r.setRating((int)business.getRating());


            return r;
        } catch (HttpClientErrorException e) {
            System.out.println(e.getResponseBodyAsString());
            throw e;
        }
    }
}




