package Models;
import java.time.LocalDate;

public class RentalHistory {
    private int rentalId;
    private String brand;
    private String carModel;
    private String clientName;
    private LocalDate rentDate;
    private LocalDate expectedReturnDate;
    private LocalDate returnDate;
    private double totalCost;
    private String status;


    public RentalHistory(int rentalId, String brand, String carModel, String clientName, LocalDate rentDate, LocalDate expectedReturnDate, LocalDate returnDate, double totalCost, String status) {
        this.rentalId = rentalId;
        this.brand = brand;
        this.carModel = carModel;
        this.clientName = clientName;
        this.rentDate = rentDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    public int getRentalId() {
        return rentalId;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getClientName() {
        return clientName;
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

    public String getStatus() {
        return status;
    }
}

