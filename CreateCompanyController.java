package controller;

import Models.Company;
import application.MainApp;
import javafx.fxml.FXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.AdminService;
import javafx.scene.control.TextField;

import java.awt.*;

public class CreateCompanyController {
    @FXML private TextField companyNameField;
    @FXML private TextField companyIdField;

    private final AdminService adminService = new AdminService();

    private static final Logger logger = LogManager.getLogger(CreateCompanyController.class);

    public void handleSubmit(){
        try {
            String companyName = companyNameField.getText();
            int companyID = Integer.parseInt(companyIdField.getText());

            adminService.createCompany(companyName,companyID);
            logger.info("Company created: {}", companyName);
            companyIdField.clear();
            companyNameField.clear();

        } catch (NumberFormatException e) {
            logger.warn("Invalid company ID input", e);
            //showError("Invalid Input", "Company ID must be a number");
        } catch (Exception e) {
            logger.error("Failed to create company", e);
           // showError("Error", "Could not create company");
        }
    }
    public void handleBack(){
        try{
            MainApp.loadAdminDashboard();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
