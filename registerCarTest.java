package testing.serviceTesting;

import Database.jpa.*;
import enums.CarClass;
import enums.Category;
import enums.CarStatus;
import models.jpa.JPACar;
import models.jpa.JPACarCharacteristics;
import org.junit.Test;
import service.OperatorService;

import static org.junit.jupiter.api.Assertions.*;

public class registerCarTest {
    @Test
    public void registerCarTest() throws Exception {
        JPACar car = new JPACar(3000,"AstonMartin","Valkyrie",2024, CarClass.LUXURY,
                Category.SEDAN,
                true,34.7,1.2,230, CarStatus.AVAILABLE);
        JPACarCharacteristics characteristics = new JPACarCharacteristics("Hybrid",
                "AUTOMATIC",
                210,"Green");
        OperatorService operatorService = new OperatorService();
        operatorService.registerCar(car,characteristics);
        assertTrue(exist.carExists(3000));
        assertTrue(exist.characteristicsExist(3000));
    }
}
