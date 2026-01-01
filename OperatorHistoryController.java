package controller;
import Database.DBQueries;
import Models.*;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

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

        operatorIdCol.setCellValueFactory(new PropertyValueFactory<>("operatorId"));
        operatorCol.setCellValueFactory(new PropertyValueFactory<>("operatorUsername"));
        rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        rentDateCol.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadActivity();
    }
    private void loadActivity() {
        activityTable.getItems().setAll(DBQueries.reportOperatorActivity());
    }
    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
