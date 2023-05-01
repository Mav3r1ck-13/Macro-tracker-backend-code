package com.macrocounter.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Food {

    private int intakeId;

    private int userId;

    @Min(value = 1)
    private int protein;

    @Min(value = 1)
    private int carbs;

    @Min(value = 1)
    private int fats;

    @NotBlank
    private String meal;

    @NotBlank
    private String foodName;

    public Food(int intakeId, int userId, int protein, int carbs, int fats, String meal, String foodName) {
        this.intakeId = intakeId;
        this.userId = userId;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.meal = meal;
        this.foodName = foodName;
    }
    // Generic constructor ----------------------------------
    public Food() {

    }
    // Getters ----------------------------------------------


    public int getIntakeId() {
        return intakeId;
    }

    public int getUserId() {
        return userId;
    }

    public int getProtein() {

        return protein;
    }

    public int getCarbs() {

        return carbs;
    }

    public int getFats() {

        return fats;
    }

    public String getMeal() {

        return meal;
    }

    public String getFoodName() {

        return foodName;
    }

    // Setters--------------------------------------------


    public void setIntakeId(int intakeId) {
        this.intakeId = intakeId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProtein(int protein) {

        this.protein = protein;
    }

    public void setCarbs(int carbs) {

        this.carbs = carbs;
    }

    public void setFats(int fats) {

        this.fats = fats;
    }

    public void setMeal(String meal) {

        this.meal = meal;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    // Calculation of calories based input
    public int calculateCalories() {
        int calories = (protein * 4) + (carbs * 4) + (fats * 9);
        return calories;
    }
}
