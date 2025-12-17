package V2;
import V2.Database.*;
import V2.Models.*;
import V2.Service.AdminService;
import V2.Service.OperatorService;
import V2.utils.enums.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        System.out.println(" Car Rental System ");
        //Admin creates a company
        AdminService adminService = new AdminService();
        adminService.createCompany("Varna Rentals",5);

        //Admin creates and Operator
        User user = adminService.createOperator("First Operator",1002);

        //Operator Registers Client
        OperatorService operatorService = new OperatorService();
        Client client = new Client(5,"Lydia","+30699878544","lydia@gmail.com",0);
        operatorService.registerClient(client);

        //Operator registers car and car characteristics
        Car car = new Car(1002,"Ferrari","Modena 360",1998, CarClass.LUXURY, Category.COUPE,false,49.7,2.9,90, Status.AVAILABLE);
        CarCharacteristics characteristics_ferrari = new CarCharacteristics(1002,"Diesel","AUTOMATIC",280,"Red");
        operatorService.registerCar(car,characteristics_ferrari);

        //Operator starts rental
        Rental another_rental = new Rental(1006,4,1002,1002, LocalDate.of(2025,12,18),LocalDate.of(1,1,1),LocalDate.of(2025,12,20),0, RentalStatus.ACTIVE,0); //return date is 1 because it will be completed with the endRental
        ConditionReport conditionReport_1008 = new ConditionReport(1007,1006,"None","None","Good","None", ReportStage.START);
        operatorService.startRental(another_rental,conditionReport_1008);

         //TaxCalculator
         Double totalCost = operatorService.taxCalculator(car,2,120,DamageLevel.NONE);
         System.out.println("The total rental cost: "+totalCost);

        //Operator ends rental and expired rental notification
        ConditionReport endReport_1008 = new ConditionReport(1007,1006,"None","None","Worn off","None",ReportStage.END);
        DBQueries.updateMileage(1006,120.0); //we update the mileage at the end of the rental
        Damage damage = new Damage(12,1001,120.0,"Damages from Condition report",DamageLevel.MAJOR);
        List<Damage> damages = new ArrayList<>(); //initialize list for inserting to database and endReport
        LocalDate returnCarDate = LocalDate.parse("2025-12-20"); //return date of the rental. Its different from the expected return date
        operatorService.endRental(another_rental,endReport_1008,damages,returnCarDate,totalCost);

        //Example Risky Client notification
        Client second_client = new Client(7,"Maria","+30699455321","maria@gmail.com",9);
        operatorService.registerClient(second_client);

        //Database reports
        DBQueries.reportAvailableCars(); //Cars
        DBQueries.reportRentedCarStatistics(); //Car statistics
        DBQueries.reportClientRatings(); //Client ratings
        DBQueries.reportRentalHistory(); // Rental History
        DBQueries.reportOperatorActivity(); //Operator Activity, regarding rentals



    }
}
