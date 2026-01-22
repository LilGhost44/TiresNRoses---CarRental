package testing.serviceTesting;
import org.junit.Test;
import service.AdminService;
import static org.junit.jupiter.api.Assertions.*;

public class authenticateTest {
    @Test
    public void authenticateTest(){
        boolean result = AdminService.authenticate(4,"Fourth Operator");
        assertEquals(result,true);
    }
}
