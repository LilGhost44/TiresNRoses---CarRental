package V2;
import V2.Database.DBQueries;
import V2.Models.*;
import V2.Service.OperatorService;
import V2.utils.enums.*;
import java.time.LocalDate;

public class Demo {

    public static void main(String[] args) {

        // 1. Create a Company object
        Company company = new Company();
        company.setCompanyID(4);
        company.setName("V5");
        // 2. Insert into the database
        int query = DBQueries.insertCompany(company);
        // 3. Check result
        if (query > 0) {
            System.out.println("Company inserted successfully!");
            System.out.println("Company ID: " + company.getCompanyID());
            System.out.println("Name: " + company.getName());
        } else {
            System.out.println("Failed to insert company.");
        }

        //insertUser
        User user = new User();
        user.setUserID(3);
        user.setRole(Role.ADMIN);
        user.setUsername("Third Operator");
        int query2 = DBQueries.insertUser(user);
        if (query2 > 0) {
            System.out.println("User inserted successfully!");
            System.out.println("User ID: " + user.getUserID());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());

        } else {
            System.out.println("Failed to insert user.");
        }
        //insertClient
        Client client = new Client();
        client.setClientID(1);
        client.setName("First client");
        client.setPhone("+306940520907");
        client.setEmail("fist@gmail.com");
        client.setRating(1.2);
        int query3 = DBQueries.insertClient(client);
        if (query3 > 0) {
            System.out.println("Client inserted successfully!");
            System.out.println("Client ID: " + client.getClientID());
            System.out.println("Name: " + client.getName());
            System.out.println("Phone: " + client.getPhone());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Rating: " + client.getRating());

        } else {
            System.out.println("Failed to insert client.");
        }
        //insertRental
        OperatorService opService = new OperatorService();
        Car car1 = new Car();
        car1.setCarClass(CarClass.CITY);
        int rentalDays = 5;
        int mileageUsed = 320;
        DamageLevel damage1 = DamageLevel.MINOR;
        double totalCost = opService.taxCalculator(car1, rentalDays, mileageUsed, damage1);

        Rental rental = new Rental();
        rental.setRentalID(2);
        rental.setClientID(1);
        rental.setCarID(1);
        rental.setOperatorID(1);
        LocalDate date = LocalDate.of(2025, 2, 10);
        rental.setRentDate(date);
        LocalDate exReturnDate = LocalDate.of(2025,02,20);
        rental.setExpectedReturnDate(exReturnDate);
        LocalDate returnDate = LocalDate.of(2025,2,20);
        rental.setReturnDate(returnDate);
        rental.setInitialMileage(0);
        rental.setReturnMileage(20);
        rental.setTotalCost(totalCost);
        rental.setRentalStatus(RentalStatus.ACTIVE);
        int query4 = DBQueries.insertRental(rental);
        if (query4 > 0) {
            System.out.println("Rental inserted successfully!");
            System.out.println("Rental ID: " + rental.getRentalID());
            System.out.println("Client ID: " + rental.getClientID());
            System.out.println("Car ID: " + rental.getCarID());
            System.out.println("Operator ID: " + rental.getOperatorID());
            System.out.println("Rental Date: " + rental.getRentDate());
            System.out.println("Expected Return Date: " + rental.getExpectedReturnDate());
            System.out.println("Return Date: " + rental.getReturnDate());
            System.out.println("Initial Mileage: " + rental.getInitialMileage());
            System.out.println("Final Mileage: " + rental.getReturnMileage());
            System.out.println("Total Cost: " + rental.getTotalCost());
            System.out.println("Rental Status: " + rental.getRentalStatus());

        } else {
            System.out.println("Failed to insert rental.");
        }
        //insertCar
        Car car = new Car();
        car.setCarID(1);
        car.setBrand("Renault");
        car.setModel("Clio V");
        car.setYear(2025);
        car.setCarClass(CarClass.CITY);
        car.setCategory(Category.COUPE);
        car.setSmokingAllowed(false);
        car.setDailyRate(29.32);
        car.setKmRate(1.2);
        car.setMileage(0);
        car.setStatus(Status.AVAILABLE);

        int query5 = DBQueries.insertCar(car);
        if (query5 > 0) {
            System.out.println("Car inserted successfully!");
            System.out.println("Car ID: " + car.getCarID());
            System.out.println("Brand: " + car.getBrand());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year Manufactured: " + car.getYear());
            System.out.println("Class: " + car.getCarClass());
            System.out.println("Category: " + car.getCategory());
            System.out.println("Smoking Allowed: " + car.isSmokingAllowed());
            System.out.println("Daily Rate: " + car.getDailyRate());
            System.out.println("Rate on KM: " + car.getKmRate());
            System.out.println("Mileage: " + car.getMileage());
            System.out.println("Status: " + car.getStatus());

        } else {
            System.out.println("Failed to insert car.");
        }
        //insertCarCharacteristics
        CarCharacteristics ch = new CarCharacteristics();
        ch.setCarID(1);
        ch.setFuelType("Diesel");
        ch.setGearBox("AUTOMATIC");
        ch.setHorsepower(100);
        ch.setColor("Black");

        int query6 = DBQueries.insertCarCharacteristics(ch);
        if (query6 > 0) {
            System.out.println("Car characteristics inserted successfully!");
            System.out.println("Car ID: " + ch.getCarID());
            System.out.println("Fuel type: " + ch.getFuelType());
            System.out.println("Gear box: " + ch.getGearBox());
            System.out.println("Horsepower: " + ch.getHorsepower());
            System.out.println("Color: " + ch.getColor());


        } else {
            System.out.println("Failed to insert characteristics.");
        }
        //insertConditionReport
        ConditionReport conditionReport = new ConditionReport();
        conditionReport.setReportID(1);
        conditionReport.setRentalID(1);
        conditionReport.setScratches("Scratches at the rear");
        conditionReport.setInteriorDamage("Positive");
        conditionReport.setTireCondition("Good");
        conditionReport.setNotes("Null");
        conditionReport.setStage(ReportStage.START);

        int query7 = DBQueries.insertConditionReport(conditionReport);
        if (query7 > 0) {
            System.out.println("Condition Report inserted successfully!");
            System.out.println("Report ID: " + conditionReport.getReportID());
            System.out.println("Rental ID: " + conditionReport.getRentalID());
            System.out.println("Scratches: " + conditionReport.getScratches());
            System.out.println("Interior Damage: " + conditionReport.getInteriorDamage());
            System.out.println("Tire Condition: " + conditionReport.getTireCondition());
            System.out.println("Notes: " + conditionReport.getNotes());
            System.out.println("Stage: " + conditionReport.getStage());


        } else {
            System.out.println("Failed to insert condition report.");
        }
        //insertDamage
        Damage damage = new Damage();
        damage.setDamageID(1);
        damage.setRentalID(1);
        damage.setCost(100);
        damage.setDescription("Bump at the right rear door");

        int query8 = DBQueries.insertDamage(damage);
        if (query8 > 0) {
            System.out.println("Damage inserted successfully!");
            System.out.println("Damage ID: " + damage.getDamageID());
            System.out.println("Rental ID: " + damage.getRentalID());
            System.out.println("Cost: " + damage.getCost());
            System.out.println("Description: " + damage.getDescription());
        } else {
            System.out.println("Failed to insert damage.");
        }
        //updateCarStatus
        int result = DBQueries.updateCarStatus(1, "RENTED");

        if (result > 0) {
            System.out.println("Car status updated!");
        } else {
            System.out.println("No car found with that ID.");
        }
        //completeRental
        ConditionReport conditionEndReport = new ConditionReport();
        conditionReport.setReportID(1);
        conditionReport.setRentalID(1);
        conditionReport.setScratches("Scratches at the rear");
        conditionReport.setInteriorDamage("Positive");
        conditionReport.setTireCondition("Worn off");
        conditionReport.setNotes("Needs service");
        conditionReport.setStage(ReportStage.END);

        int query9 = DBQueries.insertConditionReport(conditionReport);
        if (query9 > 0) {
            System.out.println("Condition Report inserted successfully!");
            System.out.println("Report ID: " + conditionReport.getReportID());
            System.out.println("Rental ID: " + conditionReport.getRentalID());
            System.out.println("Scratches: " + conditionReport.getScratches());
            System.out.println("Interior Damage: " + conditionReport.getInteriorDamage());
            System.out.println("Tire Condition: " + conditionReport.getTireCondition());
            System.out.println("Notes: " + conditionReport.getNotes());
            System.out.println("Stage: " + conditionReport.getStage());


        } else {
            System.out.println("Failed to insert condition report.");
        }
        //update automatically Rent status to completed
        int result2 = DBQueries.updateRentalStatus(1);

        if (result > 0) {
            System.out.println("Rental status updated!");
        } else {
            System.out.println("No rental found with that ID.");
        }

    }
}
