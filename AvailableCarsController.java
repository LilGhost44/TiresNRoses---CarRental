package controller;

import Database.DBQueries;
import Models.Car;
import application.MainApp;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.AdminService;
import service.OperatorService;
import enums.*;

import java.util.List;

public class AvailableCarsController {
    @FXML private TableView<Car> carTable;
    @FXML private TableColumn<Car, Integer> idCol;
    @FXML private TableColumn<Car, String> brandCol;
    @FXML private TableColumn<Car, String> modelCol;
    @FXML private TableColumn<Car, Double> dailyRateCol;


    @FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<>("carID"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        dailyRateCol.setCellValueFactory(new PropertyValueFactory<>("dailyRate"));

        loadReportAvailableCars();
    }
    private void loadReportAvailableCars() {
        carTable.getItems().setAll(DBQueries.reportAvailableCars());

    }

    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
