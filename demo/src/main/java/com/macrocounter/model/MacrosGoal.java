package com.macrocounter.model;

public class MacrosGoal {

    private int protein;
    private int carbs;
    private int fats;

    public MacrosGoal(int protein, int carbs, int fats) {
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
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
}
