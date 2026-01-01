package Models;


import enums.*;

public class Car {
    //attributes
    private int carID;
    private String brand;
    private String model;
    private int year;
    private CarClass carClass;
    private Category category;
    private boolean smokingAllowed;
    private double dailyRate;
    private double kmRate;
    private int mileage;
    private Status status;


    private CarCharacteristics characteristics;

    //constructor
    public Car() { //For DB
    }
    public Car(int carID, String brand, String model, int year, CarClass carClass, Category category, boolean smokingAllowed, double dailyRate, double kmRate, int mileage, Status status) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.carClass = carClass;
        this.category = category;
        this.smokingAllowed = smokingAllowed;
        this.dailyRate = dailyRate;
        this.kmRate = kmRate;
        this.mileage = mileage;
        this.status = status;

    }

    //getters n setters
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isSmokingAllowed() {
        return smokingAllowed;
    }

    public void setSmokingAllowed(boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
    }


    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getKmRate() {
        return kmRate;
    }

    public void setKmRate(double kmRate) {
        this.kmRate = kmRate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public CarCharacteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(CarCharacteristics characteristics) {
        this.characteristics = characteristics;
    }
}
