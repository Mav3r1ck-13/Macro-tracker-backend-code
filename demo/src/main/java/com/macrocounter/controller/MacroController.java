package com.macrocounter.controller;


import com.macrocounter.dao.FoodDao;
import com.macrocounter.model.Food;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController  //receives incoming web requests
//@RequestMapping(path = "/daily_food_intake")
public class MacroController {

    private final FoodDao foodDao;

    public MacroController( FoodDao foodDao) {
        this.foodDao = foodDao;

    }

    @RequestMapping(path = "/daily_food_intake", method = RequestMethod.GET)
    public List<Food> list() {

        return foodDao.list();
    }

    @RequestMapping(path = "/daily_food_intake/{id}", method = RequestMethod.GET)
    public Food getOneFoodItem(@PathVariable int id){
        Food food = foodDao.get(id);
        return food;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/newFood", method = RequestMethod.POST)
    public Food create (@RequestBody Food food) {
        return foodDao.createNewFood(food);
        // Look in to SQL for this (missing food_id. maybe return food_id?)
    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
//    public void deleteFood(@PathVariable int id) {
//
//        foodDao.delete(id);
//    }
}
