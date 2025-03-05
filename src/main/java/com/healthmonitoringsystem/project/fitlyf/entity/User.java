package com.healthmonitoringsystem.project.fitlyf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private double weight;
    private double height;
    private String bmiStatus;
    private boolean hasDiabetes;
    private boolean hasHighBp;
    private int sugarLevel;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public String getBmiStatus() { return bmiStatus; }
    public void setBmiStatus(String bmiStatus) { this.bmiStatus = bmiStatus; }

    public boolean isHasDiabetes() { return hasDiabetes; }
    public void setHasDiabetes(boolean hasDiabetes) { this.hasDiabetes = hasDiabetes; }

    public boolean isHasHighBp() { return hasHighBp; }
    public void setHasHighBp(boolean hasHighBp) { this.hasHighBp = hasHighBp; }

    public int getSugarLevel() { return sugarLevel; }
    public void setSugarLevel(int sugarLevel) { this.sugarLevel = sugarLevel; }
}
