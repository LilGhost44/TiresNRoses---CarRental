package controller;

import Models.Car;
import Models.CarCharacteristics;
import Models.Client;
import enums.*;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OperatorService;
import javafx.scene.control.TextField;

import java.awt.*;

public class RegisterCarController {
    @FXML private TextField carID;
    @FXML private TextField carBrand;
    @FXML private TextField carModel;
    @FXML private TextField carYear ;
    //@FXML private TextField carClass;
    @FXML private ComboBox<CarClass> carClassBox;

    //@FXML private TextField carCategory;
    @FXML private ComboBox<Category> carCategoryBox;

    //@FXML private TextField carSmoking;
    @FXML private CheckBox carSmoking;

    @FXML private TextField carDailyRate;
    @FXML private TextField carKmRate;
    @FXML private TextField carMileage;
    //@FXML private TextField carStatus;
    @FXML private ComboBox<Status> carStatusBox;

    @FXML private TextField carFuelType;
    @FXML private TextField carGearBox;
    @FXML private TextField carHorsePower;
    @FXML private TextField carColor;

    @FXML
    public void initialize() {
        carClassBox.getItems().setAll(CarClass.values());
        carCategoryBox.getItems().setAll(Category.values());
        carStatusBox.getItems().setAll(Status.values());
    }

    private final OperatorService operatorService = new OperatorService();
    private static final Logger logger = LogManager.getLogger(RegisterCarController.class);

    public void handleSubmit(){
        try {
            int carId = Integer.parseInt(carID.getText());
            String carBRand = carBrand.getText();
            String carMOdel = carModel.getText();
            int carYEar = Integer.parseInt(carYear.getText());

           // String carCLass = carClass.getText().toUpperCase();
            //CarClass carClassEnum = CarClass.valueOf(carCLass);
            CarClass carClass = carClassBox.getValue();

           // String carCAtegory = carCategory.getText().toUpperCase();
           // Category carCategoryEnum = Category.valueOf(carCAtegory);
            Category category = carCategoryBox.getValue();

           // boolean carSMoking = Boolean.parseBoolean(carSmoking.getText());
            boolean carSmokingValue = carSmoking.isSelected();
            double carDAilyRate = Double.parseDouble(carDailyRate.getText());
            double carKMRate = Double.parseDouble(carKmRate.getText());
            int carMIleage = Integer.parseInt(carMileage.getText());

            //String carSTatus = carStatus.getText().toUpperCase();
           // Status carStatusEnum = Status.valueOf(carSTatus);
            Status status = carStatusBox.getValue();

            String carFUelType = carFuelType.getText();
            String carGEarBox = carGearBox.getText();
            int carHOrsepower = Integer.parseInt(carHorsePower.getText());
            String carCOlor = carColor.getText();

            if (carClass == null || category == null || status == null) {
                logger.error("Please select class, category and status");
                return;
            }

            Car car = new Car(carId,carBRand,carMOdel,carYEar,carClass,category,carSmokingValue,carDAilyRate,carKMRate,carMIleage,status);
            CarCharacteristics characteristics = new CarCharacteristics(carId,carFUelType,carGEarBox,carHOrsepower,carCOlor);
            operatorService.registerCar(car,characteristics);

            logger.info("Car and characteristics registered: "+ carBRand +" "+carMOdel);
            carID.clear();
            carBrand.clear();
            carModel.clear();
            carYear.clear();
            carDailyRate.clear();
            carKmRate.clear();
            carMileage.clear();
            carFuelType.clear();
            carGearBox.clear();
            carHorsePower.clear();
            carColor.clear();

        } catch (NumberFormatException e) {
            logger.warn("Invalid car ID input", e);
            //showError("Invalid Input", "Company ID must be a number");
        } catch (Exception e) {
            logger.error("Failed to register car or its characteristics", e);
            // showError("Error", "Could not create company");
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
