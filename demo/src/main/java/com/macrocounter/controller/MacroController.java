package com.macrocounter.controller;


import com.macrocounter.dao.FoodDao;
import com.macrocounter.dao.MacrosDao;
import com.macrocounter.model.Food;
import com.macrocounter.model.MacrosGoal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController  //receives incoming web requests

public class MacroController {

    private final FoodDao foodDao;

    private final MacrosDao macrosDao;

    public MacroController(FoodDao foodDao, MacrosDao macrosDao) {
        this.foodDao = foodDao;

        this.macrosDao = macrosDao;
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

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/setMacros", method = RequestMethod.POST)
    public MacrosGoal createMacros (@RequestBody MacrosGoal macrosGoal) {
        return macrosDao.setMacros(macrosGoal);
    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
//    public void deleteFood(@PathVariable int id) {
//
//        foodDao.delete(id);
//    }
}
