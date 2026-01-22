package models.jpa;

/*Class for rented car statistics , for loading the data*/

public class JPARentedCarStatistics {
    private String brand;
    private String model;
    private Long timesRented;

    public JPARentedCarStatistics(String brand, String model, Long timesRented) {
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
    public Long getTimesRented() {
        return timesRented;
    }
}
