package Models;


import enums.RentalStatus;

import java.time.LocalDate;

public class Rental {
    private int rentalID;
    private int clientID;
    private int carID;
    private int operatorID;

    private LocalDate rentDate;
    private LocalDate expectedReturnDate;
    private LocalDate returnDate;

    private int initialMileage;
    private int returnMileage;
    private double totalCost;

    private RentalStatus rentalStatus;

    //constructor
    public Rental(){};
    public Rental(int rentalID, int clientID, int carID, int operatorID, LocalDate rentDate,LocalDate expectedReturnDate ,LocalDate returnDate, int initialMileage, RentalStatus rentalStatus,double totalCost) {
        this.rentalID = rentalID;
        this.clientID = clientID;
        this.carID = carID;
        this.operatorID = operatorID;
        this.rentDate = rentDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.initialMileage = initialMileage;
        this.rentalStatus = rentalStatus;
        this.totalCost = totalCost;
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
    public LocalDate getRentDate() {
        return rentDate;
    }
    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }
    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }
    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
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
