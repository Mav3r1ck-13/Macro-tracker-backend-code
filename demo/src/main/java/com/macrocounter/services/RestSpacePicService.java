package com.macrocounter.services;

import com.macrocounter.model.Food;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestSpacePicService implements SpacePicService{

    private static final String API_URL = "https://api.nasa.gov/planetary/apod";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Food getPic() {
        Food food = restTemplate.getForObject(API_URL, Food.class);
        return food;
    }
}
