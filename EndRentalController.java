package controller;
import Database.jdbc.DBQueries;
import models.jdbc.Car;
import models.jdbc.ConditionReport;
import models.jdbc.Rental;
import application.MainApp;
import enums.ReportStage;
import enums.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import models.jpa.JPACar;
import models.jpa.JPAConditionReport;
import models.jpa.JPARental;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OperatorService;
import javafx.scene.control.TextField;
import Database.jpa.get;
import Database.jpa.update;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EndRentalController {
    @FXML private TextField endRentalID;
    @FXML private TextField endReportID;
    @FXML private TextField returnDate;
    @FXML private TextField returnMileage;
    @FXML private TextField scratches;
    @FXML private TextField interiorDamage;
    @FXML private TextField tireCondition;
    @FXML private TextField notes;
    @FXML private ComboBox<ReportStage> reportStageComboBox;
    @FXML private ComboBox<DamageLevel> damageLevelComboBox;

    @FXML
    public void initialize() {
        reportStageComboBox.getItems().setAll(ReportStage.values());
        damageLevelComboBox.getItems().setAll(DamageLevel.values());
    }

    private final OperatorService operatorService = new OperatorService();
    private static final Logger logger = LogManager.getLogger(EndRentalController.class);

    public void handleSubmit(){
        try{
            int rentalIdValue = Integer.parseInt(endRentalID.getText());
            int reportIdValue = Integer.parseInt(endReportID.getText());
            LocalDate returnDateValue = LocalDate.parse(returnDate.getText());
            int returnMileageValue = Integer.parseInt(returnMileage.getText());
            String scratchesValue = scratches.getText();
            String interiorDamageValue = interiorDamage.getText();
            String tireConditionValue = tireCondition.getText();
            String notesValue = notes.getText();
            ReportStage reportStageValue = reportStageComboBox.getValue();
            DamageLevel damageLevelValue = damageLevelComboBox.getValue();

            JPARental rental = get.getRentalById(rentalIdValue); //load rental from DB
            JPACar car = get.getCarById(rental.getCarID()); //load car from DB
            int rentalDaysValue = (int) ChronoUnit.DAYS.between(rental.getRentDate(), returnDateValue); //compute rental days
            //tax Calculator
            double totalCost = operatorService.taxCalculator(car,rentalDaysValue,returnMileageValue,damageLevelValue);
            //end condition report
            JPAConditionReport endReport = new JPAConditionReport(reportIdValue,rentalIdValue,scratchesValue,interiorDamageValue,tireConditionValue,notesValue,reportStageValue);
            update.updateMileage(rentalIdValue,returnMileageValue); //update with final mileage
            update.updateMileageCar(rental.getCarID(), returnMileageValue); //update Car with extra mileage
            //end rental method
            operatorService.endRental(rental,endReport,returnDateValue,totalCost);


            logger.info("Rental completed: "+ rentalIdValue+" with cost: "+totalCost);
            endRentalID.clear();
            endReportID.clear();
            returnDate.clear();
            returnMileage.clear();
            scratches.clear();
            interiorDamage.clear();
            tireCondition.clear();
            notes.clear();


        } catch (NumberFormatException e) {
            logger.warn("Invalid rental ID input", e);
            //showError("Invalid Input", "Company ID must be a number");
        } catch (Exception e) {
            logger.error("Failed to end rental or register final condition report", e);
            // showError("Error", "Could not create company");
        }
    }
    public void handleBack(){
        try{
            MainApp.loadOperatorDashboard();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
