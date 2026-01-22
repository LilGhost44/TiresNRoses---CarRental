package service;


import Database.jdbc.DBQueries;
import Database.jpa.exist;
import Database.jpa.other;
import enums.*;
import models.jdbc.*;
import models.jpa.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Database.jpa.insert;
import Database.jpa.update;

import java.time.LocalDate;

/*Class that contains all the methods regarding the Operator operations*/

public class OperatorService {
    private static final Logger logger = LogManager.getLogger(OperatorService.class);

    public void registerClient(JPAClient client) {
        if(insert.insertClient(client)){
            logger.info("Client registration completed: " +client.getName()+" with id: "+client.getClientID());
        }else{logger.warn("Client registration failed.");}

        if(client.getRating()>5){
            logger.warn("Caution: Risky Client with rating: "+client.getRating());
        }
    }  //Register Client to Database

    public void startRental(JPARental rental, JPAConditionReport startReport) {
        if(insert.insertRental(rental)){
            logger.info("Rental started. ID: "+rental.getRentalID());
        }else{logger.error("Rental failed to start.");}
        if(insert.insertConditionReport(startReport)){
            //DBQueries.updateCarStatus(rental.getCarID(), "RENTED");    //New rental, change status to Rented
           update.updateCarStatus(rental.getCarID(),CarStatus.RENTED);
            logger.info("Condition report created.");}
        else{logger.error("Condition report failed.");};

    }

    public void endRental(JPARental rental, JPAConditionReport endReport, LocalDate returnDate,Double cost) { //As in car return
        //DBQueries.insertConditionReport(endReport);
        insert.insertConditionReport(endReport);

        if(other.completeRental(rental,endReport)>0){
            logger.info("Rental Completed.");
        }else{logger.warn("Rental completion failed.");}
        if(update.updateCarStatus(rental.getCarID(), CarStatus.AVAILABLE)==0){
            logger.info("Car status update to AVAILABLE.");
        }else{logger.warn("Status update failed.");} //set car to AVAILABLE
        if(update.updateRentalStatus(rental.getRentalID())>0){
            logger.info("Rental status set to COMPLETED.");
        }else{logger.warn("Status did not get updated.");} //set rental to COMPLETED
        if(update.updateReturnDate(rental.getRentalID(), returnDate)>=0){
            rental.setReturnDate(returnDate);
            logger.info("Return date updated: "+returnDate);
        }else{logger.warn("Return date did not get updated.");} //update with the actual returnDate

        if(update.updateCost(rental.getRentalID(),cost)>0){
            rental.setTotalCost(cost);
            logger.info("Cost updated: "+cost);
        }else{logger.warn("Cost did not get updated.");}

        if (rental.getReturnDate()
                .isAfter(rental.getExpectedReturnDate())) {
            logger.warn("Caution: This rental is expired!!!");
            other.increaseClientRating(rental.getClientID(), 2);
        }

    }
    public void registerCar(JPACar car, JPACarCharacteristics ch) {
        if(insert.insertCar(car,ch)){logger.info("Car registration complete. ID: "+car.getCarID()+" ,Details: "+car.getBrand()+" ,"+car.getModel());}
       else{logger.error("Car registration failed.");}
    }
    public double taxCalculator(JPACar car, int rentalDays, int mileage, DamageLevel damageLevel) {
        double base = getDailyRate(car.getCategory());
        double mileageRate = getMileage(car.getCarClass());
        double cost = (rentalDays * base) + (mileage * mileageRate);

        switch (damageLevel) { //For damages
            case NONE:
                return cost;
            case MINOR:
                double minorPenalty = 100;
                return cost + minorPenalty;
            case MAJOR:
                double majorPenalty = 500;
                return  cost+majorPenalty;
        }

        return cost;
    }
    private double getDailyRate(Category category) {
        switch (category) {
            case SEDAN: return 120;
            case SUV:return 100;
            case WAGON : return 70;
            case COUPE : return 50;
            default: return 0;
        }
    }
    private double getMileage(CarClass carClass) {
         switch (carClass) {
             case LUXURY: return 1.70;
             case FAMILY: return 1.50;
             case SPORT: return 2.10;
             case CITY: return 1.20;
             default: return 0;
        }
    }
    //authentication of operator
    public static boolean authenticate(int id, String username) {
        boolean exists = exist.operatorExists(id, username);
        if (!exists) {
            logger.warn("Authentication failed for user {}", username);
        }
        return exists;
    }
}
