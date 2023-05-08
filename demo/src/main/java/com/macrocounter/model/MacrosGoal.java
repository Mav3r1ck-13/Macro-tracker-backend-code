package com.macrocounter.model;

public class MacrosGoal {
    private int macrosGoalId;
    private int protein;
    private int carbs;
    private int fats;

    public MacrosGoal(int macrosGoalId, int protein, int carbs, int fats) {
        this.macrosGoalId = macrosGoalId;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }
    public MacrosGoal() {

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

    public void setMacrosGoalId(int macrosGoalId) {
        this.macrosGoalId = macrosGoalId;
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
