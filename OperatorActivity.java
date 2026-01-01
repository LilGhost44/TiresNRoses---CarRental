package Models;

import java.time.LocalDate;

public class OperatorActivity {
    private int operatorId;
    private String operatorUsername;
    private int rentalId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private double totalCost;
    private String status;


    public OperatorActivity(int operatorId, String operatorUsername,
                            int rentalId, LocalDate rentDate,
                            LocalDate returnDate,double totalCost, String status
                            ) {
        this.operatorId = operatorId;
        this.operatorUsername = operatorUsername;
        this.rentalId = rentalId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
        this.status = status;

    }

    public int getOperatorId() { return operatorId; }
    public String getOperatorUsername() { return operatorUsername; }
    public int getRentalId() { return rentalId; }
    public LocalDate getRentDate() { return rentDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public String getStatus() { return status; }
    public double getTotalCost() { return totalCost; }
}

