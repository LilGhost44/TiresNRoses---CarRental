package models.jpa;

import enums.RentalStatus;
import enums.ReportStage;
import jakarta.persistence.*;

import java.time.LocalDate;

/*Rental Entity*/

@Entity
@Table(name = "RENTAL")
public class JPARental {

    @Id
    @Column(name = "rental_id")
    private int rentalID;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private JPACar carID;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private JPAClient clientID;

    @ManyToOne
    @JoinColumn(name = "operator_id", nullable = false)
    private JPAUser userID;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "expected_rent_date")
    private LocalDate expectedReturnDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "init_mileage")
    private int initialMileage;

    @Column(name = "total_cost")
    private double totalCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "RENTAL_STATUS")
    private RentalStatus rentalStatus;



    //constructor
    public JPARental(){};
    public JPARental(int rentalID, JPAClient clientID, JPACar carID, JPAUser userID, LocalDate rentDate,LocalDate expectedReturnDate ,LocalDate returnDate, int initialMileage, RentalStatus rentalStatus,double totalCost) {
        this.rentalID = rentalID;
        this.clientID = clientID;
        this.carID = carID;
        this.userID = userID;
        this.rentDate = rentDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.initialMileage = initialMileage;
        this.rentalStatus = rentalStatus;
        this.totalCost = totalCost;
    }
    //Getter n Setter
    public int getRentalID() {
        return rentalID;
    }
    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }
    public JPAClient getClientID() {
        return clientID;
    }
    public void setClientID(JPAClient clientID) {
        this.clientID = clientID;
    }
    public JPACar getCarID() {
        return carID;
    }
    public void setCarID(JPACar carID) {
        this.carID = carID;
    }
    public JPAUser getOperatorID() {
        return userID;
    }
    public void setOperatorID(JPAUser userID) {
        this.userID = userID;
    }
    public LocalDate getRentDate() {
        return rentDate;
    }
    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }
    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }
    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public int getInitialMileage() {
        return initialMileage;
    }
    public void setInitialMileage(int initialMileage) {
        this.initialMileage = initialMileage;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }
    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
}
