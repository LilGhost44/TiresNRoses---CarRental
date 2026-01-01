package controller;


import Database.DBQueries;
import Models.Car;
import Models.ClientRating;
import Models.Rental;
import Models.RentedCarStatistics;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


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
    private void loadRatings(){
        ratingTable.getItems().setAll(DBQueries.reportClientRatings());
    }
    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
