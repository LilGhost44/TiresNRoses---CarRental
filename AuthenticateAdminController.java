package controller;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.AdminService;

public class AuthenticateAdminController {
    @FXML private TextField name;
    @FXML private TextField ID;
    private static final Logger logger = LogManager.getLogger(AuthenticateAdminController.class);

    public void handleSubmit() throws Exception {
        try {
            String username = name.getText();
            int id = Integer.parseInt(ID.getText());

            if (ID==null || username.isEmpty()) {
                logger.warn("Please fill all fields");
                return;
            }
            boolean authenticated = AdminService.authenticate(id, username);

            if (authenticated) {
                logger.info("User "+username+ " logged in as ADMINISTRATOR");
                    MainApp.loadAdminDashboard();
            } else {
                logger.warn("Failed login attempt for user {}", username);
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
