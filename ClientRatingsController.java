package controller;



import Database.jpa.get;
import javafx.collections.FXCollections;
import models.jpa.ClientRating;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.jpa.JPARentedCarStatistics;

import java.util.List;


public class ClientRatingsController {
    @FXML private TableView<ClientRating> ratingTable;
    @FXML private TableColumn<ClientRating, Integer> idCol;
    @FXML private TableColumn<ClientRating, String> nameCol;
    @FXML private TableColumn<ClientRating, Integer> ratingCol;

    @FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));

        loadRatings();
    }
    private void loadRatings() {
        List<ClientRating> ratings = get.getClientRating();
        ratingTable.setItems(FXCollections.observableArrayList(ratings));
    }
    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
