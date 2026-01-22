package controller;


import Database.jpa.get;
import javafx.collections.FXCollections;
import models.jpa.JPARentedCarStatistics;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CarStatisticsController {
    @FXML private TableView<JPARentedCarStatistics> statsTable;
    @FXML private TableColumn<JPARentedCarStatistics, String> brandCol;
    @FXML private TableColumn<JPARentedCarStatistics, String> modelCol;
    @FXML private TableColumn<JPARentedCarStatistics, Integer> timesRentedCol;


    @FXML
    public void initialize() {

        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        timesRentedCol.setCellValueFactory(new PropertyValueFactory<>("timesRented"));

        loadStatistics();
    }

    private void loadStatistics() {
        List<JPARentedCarStatistics> statistics = get.getRentedCarStatistics();
        statsTable.setItems(FXCollections.observableArrayList(statistics));
    }

    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
