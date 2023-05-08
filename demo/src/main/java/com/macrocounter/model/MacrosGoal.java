package com.macrocounter.model;

public class MacrosGoal {
    private int macrosGoalId;
    private int proteinGoal;
    private int carbsGoal;
    private int fatsGoal;

    public MacrosGoal(int macrosGoalId, int proteinGoal, int carbsGoal, int fatsGoal) {
        this.macrosGoalId = macrosGoalId;
        this.proteinGoal = proteinGoal;
        this.carbsGoal = carbsGoal;
        this.fatsGoal = fatsGoal;
    }
    public MacrosGoal() {

    }

    public int getMacrosGoalId() {
        return macrosGoalId;
    }

    public int getProtein() {
        return proteinGoal;
    }

    public int getCarbs() {
        return carbsGoal;
    }

    public int getFats() {
        return fatsGoal;
    }

    public void setMacrosGoalId(int macrosGoalId) {
        this.macrosGoalId = macrosGoalId;
    }

    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    public void setCarbsGoal(int carbsGoal) {
        this.carbsGoal = carbsGoal;
    }

    public void setFatsGoal(int fatsGoal) {
        this.fatsGoal = fatsGoal;
    }
}
