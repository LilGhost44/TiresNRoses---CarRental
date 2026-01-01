package controller;

import Database.DBQueries;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.AdminService;
import service.OperatorService;

public class AuthenticateOperatorController {

    @FXML private TextField username;
    @FXML private TextField ID;
    private static final Logger logger = LogManager.getLogger(AuthenticateOperatorController.class);

    public void handleSubmit() throws Exception {
        try {
            String name = username.getText();
            int id = Integer.parseInt(ID.getText());

            if (ID==null || name.isEmpty()) {
                logger.warn("Please fill all fields");
                return;
            }
            boolean authenticated = OperatorService.authenticate(id, name);

            if (authenticated) {
                logger.info("User "+name+" logged in as OPERATOR");

                DBQueries.logExpiredRentalsForOperator(id); //notifications
                DBQueries.logRiskyClients();

                MainApp.loadOperatorDashboard();
            } else {
                logger.warn("Failed login attempt for user "+name);
            }
        } catch (NumberFormatException e) {
            logger.error("ID must be a number");
        }


    }

    public void handleBack(){
        try{
            MainApp.loadLogin();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
