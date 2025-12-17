package V2.Models;

import V2.utils.enums.DamageLevel;

public class Damage {
    private int damageID;
    private int rentalID;
    private double cost;
    private String description;


    public Damage(){};
    public Damage(int damageID, int rentalID, double cost, String description,DamageLevel damageLevel) {
        this.damageID = damageID;
        this.rentalID = rentalID;
        this.cost = cost;
        this.description = description;

    }
    //Getters n Setters
    public int getDamageID() {
        return damageID;
    }
    public void setDamageID(int damageID) {
        this.damageID = damageID;
    }
    public int getRentalID() {
        return rentalID;
    }
    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
