package controller;

import application.MainApp;

public class AdminController {
    public void handleCreateCompany(){
        try{
            MainApp.loadCreateCompany();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void handleRegisterOperator(){
        try{
            MainApp.loadRegisterOperator();
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
