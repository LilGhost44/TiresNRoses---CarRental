package V2.Models;

import V2.utils.enums.*;

public class Rental {
    private int rentalID;
    private int clientID;
    private int carID;
    private int operatorID;

    private String rentDate;
    private String expectedReturnDate;
    private String returnDate;

    private int initialMileage;
    private int returnMileage;
    private double totalCost;

    private RentalStatus rentalStatus;

    //constructor

    public Rental(int rentalID, int clientID, int carID, int operatorID, String rentDate, String returnDate, int initialMileage, RentalStatus rentalStatus) {
        this.rentalID = rentalID;
        this.clientID = clientID;
        this.carID = carID;
        this.operatorID = operatorID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.initialMileage = initialMileage;
        this.rentalStatus = rentalStatus;
    }
    //Getter n Setter

    public int getRentalID() {
        return rentalID;
    }
    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public int getCarID() {
        return carID;
    }
    public void setCarID(int carID) {
        this.carID = carID;
    }
    public int getOperatorID() {
        return operatorID;
    }
    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }
    public String getRentDate() {
        return rentDate;
    }
    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }
    public String getExpectedReturnDate() {
        return expectedReturnDate;
    }
    public void setExpectedReturnDate(String expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public int getInitialMileage() {
        return initialMileage;
    }
    public void setInitialMileage(int initialMileage) {
        this.initialMileage = initialMileage;
    }
    public int getReturnMileage() {
        return returnMileage;
    }
    public void setReturnMileage(int returnMileage) {
        this.returnMileage = returnMileage;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }
    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
}
