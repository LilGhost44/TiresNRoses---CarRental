package models.jpa;
import enums.RentalStatus;

import java.time.LocalDate;

/*Class for rental history, for loading data*/

public class RentalHistory {
    private Integer rentalID; //wrappers
    private String brand;
    private String model;
    private String name;
    private LocalDate rentDate;
    private LocalDate expectedReturnDate;
    private LocalDate returnDate;
    private Double totalCost;
    private RentalStatus rentalStatus;


    public RentalHistory(
            Integer rentalID,
            String brand,
            String model,
            String name,
            LocalDate rentDate,
            LocalDate expectedReturnDate,
            LocalDate returnDate,
            Double totalCost,
            RentalStatus rentalStatus
    ) {
        this.rentalID = rentalID;
        this.brand = brand;
        this.model = model;
        this.name = name;
        this.rentDate = rentDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
        this.rentalStatus = rentalStatus;
    }

    public int getRentalID() {
        return rentalID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }
}

