package models.jpa;
import enums.CarClass;
import enums.Category;
import enums.CarStatus;
import jakarta.persistence.*;

/*Car Entity*/

@Entity
@Table(name = "CAR")
public class JPACar {


        @Id
        @Column(name = "car_id")
        private int carID;
        @Column(name = "brand")
        private String brand;
        @Column(name = "car_model")
        private String model;
        @Column(name = "car_year")
        private int year;
        @Enumerated(EnumType.STRING)
        @Column(name = "CAR_CLASS")
        private CarClass carClass;
        @Enumerated(EnumType.STRING)
        @Column(name = "CAR_CATEGORY")
        private Category category;
        @Column(name = "smoking_allowed")
        private boolean smokingAllowed;
        @Column(name  = "daily_rate")
        private double dailyRate;
        @Column(name = "km_rate")
        private double kmRate;
        @Column(name = "mileage")
        private int mileage;
        @Enumerated(EnumType.STRING)
        @Column(name = "CAR_STATUS")
        private CarStatus carStatus;


    //private JPACarCharacteristics characteristics;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private JPACarCharacteristics characteristics;

        // constructor
    public JPACar(){};
    public JPACar(int carID, String brand, String model, int year, CarClass carClass, Category category, boolean smokingAllowed, double dailyRate, double kmRate, int mileage, CarStatus carStatus) {
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
        this.carStatus = carStatus;
    }
    //getters and setters
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

    public CarStatus getStatus() {
        return carStatus;
    }

    public void setStatus(CarStatus status) {
        this.carStatus = carStatus;
    }


    public JPACarCharacteristics getCharacteristics() {
        return characteristics;
    }
    public void setCharacteristics(JPACarCharacteristics characteristics) {
        this.characteristics = characteristics;
    }
}
