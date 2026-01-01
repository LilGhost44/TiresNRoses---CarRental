package controller;

import Database.DBQueries;
import Models.Car;
import Models.Rental;
import Models.RentedCarStatistics;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CarStatisticsController {
    @FXML private TableView<RentedCarStatistics> statsTable;
    @FXML private TableColumn<RentedCarStatistics, String> brandCol;
    @FXML private TableColumn<RentedCarStatistics, String> modelCol;
    @FXML private TableColumn<RentedCarStatistics, Integer> timesRentedCol;


    @FXML
    public void initialize() {

        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        timesRentedCol.setCellValueFactory(new PropertyValueFactory<>("timesRented"));

        loadStatistics();
    }
    private void loadStatistics() {
        statsTable.getItems().setAll(DBQueries.reportRentedCarStatistics());

    }

    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
