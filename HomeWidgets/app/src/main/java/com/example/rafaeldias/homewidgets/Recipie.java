package com.example.rafaeldias.homewidgets;

public class Recipie {
    // The recipie include name of food item and steps to
    // cook it.
    private String name;
    private String steps;
    public Recipie(String name, String steps)
    {
        this.name = name;
        this.steps = steps;
    }
    // Getters and Setters
    public String getName()
    { return name; }

    public void setName(String name)
    { this.name = name; }

    public String getSteps()
    { return steps; }
}