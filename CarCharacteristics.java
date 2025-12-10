package V2.Models;

public class CarCharacteristics {
    private int carID;
    private String fuelType;
    private String gearBox;
    private int horsepower;
    private String color;


    //constructor
    public CarCharacteristics(int carID, String fuelType, String gearBox, int horsepower, String color) {
        this.carID = carID;
        this.fuelType = fuelType;
        this.gearBox = gearBox;
        this.horsepower = horsepower;
        this.color = color;
    }
    //Getter n Setter
    public int getCarID() {
        return carID;
    }
    public void setCarID(int carID) {
        this.carID = carID;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public String getGearBox() {
        return gearBox;
    }
    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }
    public int getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
