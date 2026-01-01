package controller;

import application.MainApp;

public class DatabaseReportsController {
    public void handleAvailableCars(){
        try{
            MainApp.loadAvailableCars();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleCarStatistics(){
        try{
            MainApp.loadCarStatistics();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleClientRatings(){
        try{
            MainApp.loadClientRatings();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleRentalHistory(){
        try{
            MainApp.loadRentalHistory();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleOperatorActivity(){
        try{
            MainApp.loadOperatorActivity();
        }catch(Exception e){
            e.printStackTrace();
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
