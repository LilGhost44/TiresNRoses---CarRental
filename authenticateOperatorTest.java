package testing.serviceTesting;
import org.junit.Test;
import service.OperatorService;
import static org.junit.jupiter.api.Assertions.*;

public class authenticateOperatorTest {
    @Test
    public void authenticateOperatorTest(){
       boolean result = OperatorService.authenticate(1,"First Operator");
       assertEquals(true,result);
    }
}
