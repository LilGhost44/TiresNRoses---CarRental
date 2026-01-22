package controller;


import Database.jpa.get;
import javafx.collections.FXCollections;
import models.jpa.JPACar;
import models.jpa.RentalHistory;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;


public class RentalHistoryController {
    @FXML private TableView<RentalHistory> historyTable;

    @FXML private TableColumn<RentalHistory, Integer> rentalIdCol;
    @FXML private TableColumn<RentalHistory, String> brandCol;
    @FXML private TableColumn<RentalHistory, String> modelCol;
    @FXML private TableColumn<RentalHistory, String> clientCol;
    @FXML private TableColumn<RentalHistory, LocalDate> rentDateCol;
    @FXML private TableColumn<RentalHistory, LocalDate> expectedReturnCol;
    @FXML private TableColumn<RentalHistory, LocalDate> returnDateCol;
    @FXML private TableColumn<RentalHistory, Double> costCol;
    @FXML private TableColumn<RentalHistory, String> statusCol;

    @FXML
    public void initialize() {

        rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rentalID"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        rentDateCol.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        expectedReturnCol.setCellValueFactory(new PropertyValueFactory<>("expectedReturnDate"));
        returnDateCol.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("rentalStatus"));

        loadHistory();
    }
    private void loadHistory() {
        List<RentalHistory> history = get.getRentalHistory();
        historyTable.setItems(FXCollections.observableArrayList(history));
    }
    public void handleBack(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
