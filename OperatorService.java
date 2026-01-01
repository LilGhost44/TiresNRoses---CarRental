package service;


import Database.*;
import Models.*;
import enums.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class OperatorService {
    private static final Logger logger = LogManager.getLogger(OperatorService.class);

    public void registerClient(Client client) {

        if(DBQueries.insertClient(client)>0){
            logger.info("Client registration completed: " +client.getName()+" with id: "+client.getClientID());
        }else{logger.warn("Client registration failed.");}

        if(client.getRating()>5){
            logger.warn("Caution: Risky Client with rating: "+client.getRating());
        }
    }  //Register Client to Database

    public void startRental(Rental rental, ConditionReport startReport) {
        if(DBQueries.insertRental(rental)>0){
            logger.info("Rental started. ID: "+rental.getRentalID());
        }else{logger.error("Rental failed to start.");}
        if(DBQueries.insertConditionReport(startReport)>0){
            DBQueries.updateCarStatus(rental.getCarID(), "RENTED");    //New rental, change status to Rented
            logger.info("Condition report created.");}
        else{logger.error("Condition report failed.");};

    }

    public void endRental(Rental rental, ConditionReport endReport, LocalDate returnDate,Double cost) { //As in car return
        DBQueries.insertConditionReport(endReport);

        /*for (Damage d : damage) {
            if(DBQueries.insertDamage(d)>0){System.out.println("Damage registered.");}
            else{System.out.println("Damage registration failed.");}};*/



        if(DBQueries.completeRental(rental, endReport)>0){
            logger.info("Rental Completed.");
        }else{logger.warn("Rental completion failed.");}
        if(DBQueries.updateCarStatus(rental.getCarID(), "AVAILABLE")>0){
            logger.info("Car status update to AVAILABLE.");
        }else{logger.warn("Status update failed.");} //set car to AVAILABLE
        if(DBQueries.updateRentalStatus(rental.getRentalID())>0){
            logger.info("Rental status set to COMPLETED.");
        }else{logger.warn("Status did not get updated.");} //set rental to COMPLETED
        if(DBQueries.updateReturnDate(rental.getRentalID(), returnDate)>0){
            rental.setReturnDate(returnDate);
            logger.info("Return date updated: "+returnDate);
        }else{logger.warn("Return date did not get updated.");} //update with the actual returnDate
        if(DBQueries.updateCost(rental.getRentalID(),cost)>0){
            rental.setTotalCost(cost);
            logger.info("Cost updated: "+cost);
        }else{logger.warn("Cost did not get updated.");} //update with the actual returnDate

        if (rental.getReturnDate()
                .isAfter(rental.getExpectedReturnDate())) {
            logger.warn("Caution: This rental is expired!!!");
            DBQueries.increaseClientRating(rental.getClientID(), 2);
        }

    }
    public void registerCar(Car car, CarCharacteristics ch) {
        if(DBQueries.insertCar(car)>0){logger.info("Car registration complete. ID: "+car.getCarID()+" ,Details: "+car.getBrand()+" ,"+car.getModel());}
       else{logger.error("Car registration failed.");}
        if(DBQueries.insertCarCharacteristics(ch)>0){logger.info("Car characteristics registration complete.");}
        else{logger.error("Car characteristics registration failed.");}
    }
    public double taxCalculator(Car car, int rentalDays, int mileage, DamageLevel damageLevel) {
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
        boolean exists = DBQueries.operatorExists(id, username);
        if (!exists) {
            logger.warn("Authentication failed for user {}", username);
        }
        return exists;

    }
}
