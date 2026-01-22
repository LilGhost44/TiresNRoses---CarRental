package controller;

import Database.jdbc.DBQueries;
import javafx.collections.FXCollections;
import models.jdbc.Car;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Database.jpa.reports;
import models.jpa.JPACar;
import java.util.List;
import Database.jpa.get;

public class AvailableCarsController { //for loading database data
    @FXML private TableView<JPACar> carTable;
    @FXML private TableColumn<JPACar, Integer> idCol;
    @FXML private TableColumn<JPACar, String> brandCol;
    @FXML private TableColumn<JPACar, String> modelCol;
    @FXML private TableColumn<JPACar, Double> dailyRateCol;


    @FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<>("carID"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        dailyRateCol.setCellValueFactory(new PropertyValueFactory<>("dailyRate"));

        loadReportAvailableCars();
    }

    private void loadReportAvailableCars() {
        List<JPACar> availableCars = get.getAvailableCars();
        carTable.setItems(FXCollections.observableArrayList(availableCars));
    }

    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
