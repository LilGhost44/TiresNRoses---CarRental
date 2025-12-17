package V2.Service;


import V2.utils.enums.*;
import V2.Models.*;

import java.time.LocalDate;
import java.util.List;
import V2.Database.*;

public class OperatorService {

    public void registerClient(Client client) {

        if(DBQueries.insertClient(client)>0){
            System.out.println("Client registration completed: " +client.getName()+" with id: "+client.getClientID());
        }else{System.out.println("Client registration failed.");}

        if(client.getRating()>5){
            System.out.println("Caution: Risky Client with rating: "+client.getRating());
        }
    }  //Register Client to Database

    public void startRental(Rental rental, ConditionReport startReport) {
        if(DBQueries.insertRental(rental)>0){
            System.out.println("Rental started. ID: "+rental.getRentalID());
        }else{System.out.println("Rental failed to start.");}
        if(DBQueries.insertConditionReport(startReport)>0){
            DBQueries.updateCarStatus(rental.getCarID(), "RENTED");    //New rental, change status to Rented
            System.out.println("Condition report created.");}
        else{System.out.println("Condition report failed.");};

    }

    public void endRental(Rental rental, ConditionReport endReport, List<Damage> damage, LocalDate returnDate,Double cost) { //As in car return
        DBQueries.insertConditionReport(endReport);

        for (Damage d : damage) {
            if(DBQueries.insertDamage(d)>0){System.out.println("Damage registered.");}
            else{System.out.println("Damage registration failed.");}};



        if(DBQueries.completeRental(rental, endReport,damage)>0){
            System.out.println("Rental Completed.");
        }else{System.out.println("Rental completion failed.");}
        if(DBQueries.updateCarStatus(rental.getCarID(), "AVAILABLE")>0){
            System.out.println("Car status update to AVAILABLE.");
        }else{System.out.println("Status update failed.");} //set car to AVAILABLE
        if(DBQueries.updateRentalStatus(rental.getRentalID())>0){
            System.out.println("Rental status set to COMPLETED.");
        }else{System.out.println("Status did not get updated.");} //set rental to COMPLETED
        if(DBQueries.updateReturnDate(rental.getRentalID(), returnDate)>0){
            rental.setReturnDate(returnDate);
            System.out.println("Return date updated: "+returnDate);
        }else{System.out.println("Return date did not get updated.");} //update with the actual returnDate
        if(DBQueries.updateCost(rental.getRentalID(),cost)>0){
            rental.setTotalCost(cost);
            System.out.println("Return date updated: "+returnDate);
        }else{System.out.println("Return date did not get updated.");} //update with the actual returnDate

        if (rental.getReturnDate()
                .isAfter(rental.getExpectedReturnDate())) {
            System.out.println("Caution: This rental is expired!!!");
            DBQueries.increaseClientRating(rental.getClientID(), 2);
        }

    }
    public void registerCar(Car car, CarCharacteristics ch) {
        if(DBQueries.insertCar(car)>0){System.out.println("Car registration complete. ID: "+car.getCarID()+" ,Details: "+car.getBrand()+" ,"+car.getModel());}
       else{System.out.println("Car registration failed.");}
        if(DBQueries.insertCarCharacteristics(ch)>0){System.out.println("Car characteristics registration comoplete.");}
        else{System.out.println("Car characteristics registration failed.");}
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
}
