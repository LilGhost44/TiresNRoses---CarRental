package controller;

import Database.jpa.jpa;
import jakarta.persistence.EntityManager;
import models.jdbc.ConditionReport;
import models.jdbc.Rental;
import application.MainApp;
import enums.ReportStage;
import enums.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import models.jpa.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OperatorService;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class StartRentalController {
    @FXML private TextField rentalID;
    @FXML private TextField clientID;
    @FXML private TextField carID;
    @FXML private TextField operatorID;
    @FXML private TextField rentDate;
    @FXML private TextField expectedReturnDate;
    @FXML private TextField returnDate;
    @FXML private TextField initMileage;
    @FXML private ComboBox<RentalStatus> rentalStatusComboBox;
    @FXML private TextField totalCost;

    @FXML private TextField reportID;
    @FXML private TextField scratches;
    @FXML private TextField interiorDamage;
    @FXML private TextField tireCondition;
    @FXML private TextField notes;
    @FXML private ComboBox<ReportStage> reportStageComboBox;

    @FXML
    public void initialize() {
        reportStageComboBox.getItems().setAll(ReportStage.values());
        rentalStatusComboBox.getItems().setAll(RentalStatus.values());
    }

    private final OperatorService operatorService = new OperatorService();
    private static final Logger logger = LogManager.getLogger(StartRentalController.class);

    public void handleSubmit() {
        try{
        int rentalIdValue = Integer.parseInt(rentalID.getText());
        int clientIdValue = Integer.parseInt(clientID.getText());
        int carIdValue = Integer.parseInt(carID.getText());
        int operatorIdValue = Integer.parseInt(operatorID.getText());
        LocalDate rentDateValue = LocalDate.parse(rentDate.getText());
        LocalDate expectedReturnDateValue = LocalDate.parse(expectedReturnDate.getText());
        LocalDate returnDateValue = LocalDate.parse(returnDate.getText());
        int initMileageValue = Integer.parseInt(initMileage.getText());
        RentalStatus rentalStatusValue = rentalStatusComboBox.getValue();
        double totalCostValue = Double.parseDouble(totalCost.getText());
        int reportIdValue = Integer.parseInt(reportID.getText());
        String scratchesValue = scratches.getText();
        String interiorDamageValue = interiorDamage.getText();
        String tireConditionValue = tireCondition.getText();
        String notesValue = notes.getText();
        ReportStage reportStageValue = reportStageComboBox.getValue();

            EntityManager em = jpa.getEntityManager();

        JPARental rental = new JPARental(rentalIdValue,em.find(JPAClient.class, clientIdValue),em.find(JPACar.class, carIdValue),em.find(JPAUser.class, operatorIdValue),rentDateValue,expectedReturnDateValue,returnDateValue,initMileageValue,rentalStatusValue,totalCostValue);
        JPAConditionReport startReport = new JPAConditionReport(reportIdValue,rentalIdValue,scratchesValue,interiorDamageValue,tireConditionValue,notesValue,reportStageValue);
        operatorService.startRental(rental,startReport);

            logger.info("Rental and condition report entered successfully: "+ rentalIdValue +" "+rentDateValue);
            rentalID.clear();
            clientID.clear();
            carID.clear();
            operatorID.clear();
            rentDate.clear();
            returnDate.clear();
            expectedReturnDate.clear();
            initMileage.clear();
            totalCost.clear();
            reportID.clear();
            scratches.clear();
            interiorDamage.clear();
            tireCondition.clear();
            notes.clear();


        } catch (NumberFormatException e) {
            logger.warn("Invalid rental ID input", e);
            //showError("Invalid Input", "Company ID must be a number");
        } catch (Exception e) {
            logger.error("Failed to start rental or register condition report", e);
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
