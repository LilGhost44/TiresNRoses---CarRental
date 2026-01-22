package models.jpa;

import jakarta.persistence.*;

/*Car Characteristics entity*/

@Entity
@Table(name = "CARCHARACTERISTICS")
public class JPACarCharacteristics {


    @Id
    @Column(name = "car_id")
    private int carID;

    @OneToOne
    @MapsId
    @JoinColumn(name = "car_id") // FK to JPACar
    private JPACar car;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "gear_box")
    private String gearBox;

    @Column(name = "horse_power")
    private int horsepower;

    @Column(name = "color")
    private String color;



    //constructor
    public JPACarCharacteristics(){};
    public JPACarCharacteristics(String fuelType, String gearBox, int horsepower, String color) {
       // this.carID = carID;
        this.fuelType = fuelType;
        this.gearBox = gearBox;
        this.horsepower = horsepower;
        this.color = color;
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
    public void setCar(JPACar car) { this.car = car; }
    public JPACar getCar() { return car; }
}
