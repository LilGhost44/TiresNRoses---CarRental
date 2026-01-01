package controller;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.AdminService;
import service.OperatorService;

public class RegisterOperatorController {
    @FXML private TextField username;
    @FXML private TextField operatorID;

    private final AdminService adminService = new AdminService();

    private static final Logger logger = LogManager.getLogger(RegisterOperatorController.class);

    public void handleSubmit(){
        try {
            String usernameOperator = username.getText();
            int operatorId = Integer.parseInt(operatorID.getText());

            adminService.createOperator(usernameOperator,operatorId);
            logger.info("Operator registered: "+ usernameOperator);
            username.clear();
            operatorID.clear();

        } catch (NumberFormatException e) {
            logger.warn("Invalid operator ID input", e);
            //showError("Invalid Input", "Company ID must be a number");
        } catch (Exception e) {
            logger.error("Failed to create operator", e);
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
