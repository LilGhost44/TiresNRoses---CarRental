package testing.serviceTesting;
import models.jdbc.Car;
import enums.CarClass;
import enums.Category;
import enums.DamageLevel;
import enums.CarStatus;
import models.jpa.JPACar;
import org.junit.Test;
import service.OperatorService;

import static org.junit.jupiter.api.Assertions.*;

public class taxCalculatorTest {
    @Test
    public void taxCalculatorTest(){
        JPACar car = new JPACar(3000,"AstonMartin","Valkyrie",2024, CarClass.LUXURY,
                Category.SEDAN,
                true,34.7,1.2,230, CarStatus.AVAILABLE);
        OperatorService operatorService = new OperatorService();
        double cost = operatorService.taxCalculator(car,2,80, DamageLevel.MINOR);
        assertEquals(476.0,cost);
    }
}
