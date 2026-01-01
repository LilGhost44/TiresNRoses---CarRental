package controller;

import application.MainApp;

public class OperatorController {

    public void handleRegisterClient(){
        try{
            MainApp.loadRegisterClient();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleRegisterCar(){
        try{
            MainApp.loadRegisterCar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleStartRental(){
        try{
            MainApp.loadStartRental();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleEndRental(){
        try{
            MainApp.loadEndRental();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleDatabaseReports(){
        try{
            MainApp.loadDatabaseReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleBack(){
        try{
            MainApp.loadLogin();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
