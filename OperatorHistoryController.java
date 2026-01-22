package controller;

import Database.jpa.get;
import application.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.jpa.OperatorActivity;
import models.jpa.RentalHistory;

import java.time.LocalDate;
import java.util.List;

public class OperatorHistoryController {
    @FXML private TableView<OperatorActivity> activityTable;

    @FXML private TableColumn<OperatorActivity, Integer> operatorIdCol;
    @FXML private TableColumn<OperatorActivity, String> operatorCol;
    @FXML private TableColumn<OperatorActivity, Integer> rentalIdCol;
    @FXML private TableColumn<OperatorActivity, LocalDate> rentDateCol;
    @FXML private TableColumn<OperatorActivity, Double> costCol;
    @FXML private TableColumn<OperatorActivity, String> statusCol;

    @FXML
    public void initialize() {

        operatorIdCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        operatorCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rentalID"));
        rentDateCol.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("rentalStatus"));

        loadActivity();
    }
    private void loadActivity() {
        List<OperatorActivity> activity = get.getOperatorActivity();
        activityTable.setItems(FXCollections.observableArrayList(activity));
    }
    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
