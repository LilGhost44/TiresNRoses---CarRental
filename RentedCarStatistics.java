package Models;

public class RentedCarStatistics {
    private String brand;
    private String model;
    private int timesRented;

    public RentedCarStatistics(String brand, String model, int timesRented) {
        this.brand = brand;
        this.model = model;
        this.timesRented = timesRented;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public int getTimesRented() {
        return timesRented;
    }
}
