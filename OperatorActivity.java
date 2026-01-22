package models.jpa;

import enums.RentalStatus;

import java.time.LocalDate;

/*Class with operator activity, for loading data*/

public class OperatorActivity {
    private int userID;
    private String username;
    private int rentalID;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private double totalCost;
    private RentalStatus rentalStatus;


    public OperatorActivity(int userID, String username,
                            int rentalID, LocalDate rentDate,
                            LocalDate returnDate, double totalCost, RentalStatus rentalStatus
                            ) {
        this.userID = userID;
        this.username = username;
        this.rentalID = rentalID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
        this.rentalStatus = rentalStatus;

    }

    public int getUserID() { return userID; }
    public String getUsername() { return username; }
    public int getRentalID() { return rentalID; }
    public LocalDate getRentDate() { return rentDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public RentalStatus getRentalStatus() { return rentalStatus; }
    public double getTotalCost() { return totalCost; }
}

