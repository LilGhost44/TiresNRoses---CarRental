package V2;

import V2.Models.Car;
import V2.Models.Client;
import V2.Models.Rental;
import V2.Service.OperatorService;
import V2.utils.enums.*;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        //taxCalculator Demo
        OperatorService operatorService = new OperatorService();
        Car car = new Car(1,"Ferrari","Purossangue",2024, CarClass.LUXURY, Category.SEDAN,true,10.2,2,120, Status.AVAILABLE);

        LocalDate rentDate = LocalDate.of(2025, 12, 12);
        LocalDate returnDate = LocalDate.of(2025, 12, 15);
        Rental rental = new Rental(1,2,1,1,rentDate,returnDate,120, RentalStatus.ACTIVE);
        double total = operatorService.taxCalculator(car,5,120, DamageLevel.NONE);
        System.out.println("The total cost is: " + total);
        //Risky client demo
        Client client = new Client(5,"George","+30699455321","george@gmail.com",6.7);
        operatorService.registerClient(client);
    }

}
