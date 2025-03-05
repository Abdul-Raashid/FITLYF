package com.healthmonitoringsystem.project.fitlyf.dto;

public class HealthDetailsDTO {
    private double weight;
    private double height;
    private String bp;
    private int sugar;
    private int exercise;

    // ✅ Constructor
    public HealthDetailsDTO(double weight, double height, String bp, int sugar, int exercise) {
        this.weight = weight;
        this.height = height;
        this.bp = bp;
        this.sugar = sugar;
        this.exercise = exercise;
    }

    // ✅ Getters
    public double getWeight() { return weight; }
    public double getHeight() { return height; }
    public String getBp() { return bp; }
    public int getSugar() { return sugar; }
    public int getExercise() { return exercise; }
}
