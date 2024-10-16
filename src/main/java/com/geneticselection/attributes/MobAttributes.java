package com.geneticselection.attributes;

public class MobAttributes {
    private double movementSpeed;
    private double maxHealth;
    // Add other attributes as needed

    public MobAttributes(double movementSpeed, double maxHealth) {
        this.movementSpeed = movementSpeed;
        this.maxHealth = maxHealth;
    }

    public double getMovementSpeed() { return movementSpeed; }
    public void setMovementSpeed(double movementSpeed) { this.movementSpeed = movementSpeed; }

    public double getMaxHealth() { return maxHealth; }
    public void setMaxHealth(double maxHealth) { this.maxHealth = maxHealth; }

    // Add getters and setters for additional attributes
}