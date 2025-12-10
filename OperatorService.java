package V2.Service;


import V2.utils.enums.*;
import V2.Models.*;
import java.util.List;
import V2.Database.*;

public class OperatorService {

    public void registerClient(Client client) {
        DBQueries.insertClient(client);
    }  //Register Client to Database

    public void startRental(Rental rental, ConditionReport startReport) {
        DBQueries.insertRental(rental);
        DBQueries.insertConditionReport(startReport);
        DBQueries.updateCarStatus(rental.getCarID(), "RENTED");    //New rental, change status to Rented
    }

    public void endRental(int rentalId, ConditionReport endReport, List<Damage> damages) { //As in car return
        DBQueries.insertConditionReport(endReport);

        for (Damage d : damages) {
            DBQueries.insertDamage(d);
        }

        DBQueries.completeRental(rentalId, endReport, damages);
    }
    public void registerCar(Car car, CarCharacteristics ch) {
        DBQueries.insertCar(car);
        DBQueries.insertCarCharacteristics(ch);
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
                break;
            case MAJOR:
                double majorPenalty = 500;
                break;
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
