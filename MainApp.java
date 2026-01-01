package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MainApp extends Application{
    private static Stage primaryStage;
    //log4j here
    private static final Logger logger = LogManager.getLogger(MainApp.class);


    @Override
    public void start(Stage stage) throws Exception{

        logger.info("JavaFX application starting...");

        primaryStage = stage;
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.setMinWidth(1000);
        stage.setMinHeight(700);
        stage.centerOnScreen();


        loadLogin();

        logger.info("Login screen loaded successfully.");

        logger.warn("This is a warning.");
        logger.error("This is an error test.");
    }

    public static void loadLogin() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/login.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Tyres And Roses - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void loadAdminDashboard() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/admin.fxml"));
        Scene scene = new Scene (loader.load());
        primaryStage.setTitle("Administrator Dashboard");
        primaryStage.setScene(scene);
    }

    public static void loadOperatorDashboard() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/operator.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Operator Dashboard");
        primaryStage.setScene(scene);
    }

    public static void loadCreateCompany() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/createCompany.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Create Company");
        primaryStage.setScene(scene);
    }
    public static void loadRegisterOperator() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/registerOperator.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Register Operator");
        primaryStage.setScene(scene);
    }
    public static void loadRegisterClient() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/registerClient.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Register Client");
        primaryStage.setScene(scene);
    }
    public static void loadRegisterCar() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/registerCar.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Register Car");
        primaryStage.setScene(scene);
    }

    public static void loadStartRental() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/startRental.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Start Rental");
        primaryStage.setScene(scene);
    }
    public static void loadEndRental() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/endRental.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("End Rental");
        primaryStage.setScene(scene);
    }
    public static void loadDatabaseReports() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/databaseReports.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Database Reports");
        primaryStage.setScene(scene);
    }

    public static void loadAuthenticateAdmin() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/authenticateAdmin.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Authenticate Administrator Page");
        primaryStage.setScene(scene);
    }
    public static void loadAuthenticateOperator() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/authenticateOperator.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Authenticate Operator Page");
        primaryStage.setScene(scene);
    }
    public static void loadAvailableCars() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/availableCars.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Available Cars Report");
        primaryStage.setScene(scene);
    }
    public static void loadCarStatistics() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/carStatistics.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Car Statistics Report");
        primaryStage.setScene(scene);
    }
    public static void loadClientRatings() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/clientRatings.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Client Ratings Report");
        primaryStage.setScene(scene);
    }
    public static void loadRentalHistory() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/rentalHistory.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Rental History Report");
        primaryStage.setScene(scene);
    }
    public static void loadOperatorActivity() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/operatorActivity.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Operator Activity");
        primaryStage.setScene(scene);
    }
    public static void main(String[] args){
        launch(args);
    }
}
