package controller;

import models.jdbc.Client;
import application.MainApp;
import javafx.fxml.FXML;
import models.jpa.JPAClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OperatorService;
import javafx.scene.control.TextField;

public class RegisterClientController {
    @FXML private TextField clientID;
    @FXML private TextField clientName;
    @FXML private TextField clientPhone;
    @FXML private TextField clientEmail;
    @FXML private TextField clientRating;

    private final OperatorService operatorService = new OperatorService();
    private static final Logger logger = LogManager.getLogger(RegisterClientController.class);

    public void handleSubmit(){
        try {
            int clientId = Integer.parseInt(clientID.getText());
            String clientNAme = clientName.getText();
            String clientPHone = clientPhone.getText();
            String clientEMail = clientEmail.getText();
            double clientRAting = Double.parseDouble(clientRating.getText());

            JPAClient client = new JPAClient(clientId,clientNAme,clientPHone,clientEMail,clientRAting);
            operatorService.registerClient(client);

            logger.info("Client registered: "+ clientNAme);
            clientName.clear();
            clientID.clear();
            clientPhone.clear();
            clientEmail.clear();
            clientRating.clear();

        } catch (NumberFormatException e) {
            logger.warn("Invalid client ID input", e);
            //showError("Invalid Input", "Company ID must be a number");
        } catch (Exception e) {
            logger.error("Failed to register client", e);
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
