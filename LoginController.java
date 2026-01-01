package controller;

import application.MainApp;

public class LoginController {
    public void handleAdminLogin(){
        try{
            MainApp.loadAuthenticateAdmin();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void handleOperatorLogin(){
        try{
            MainApp.loadAuthenticateOperator();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
