package testing.serviceTesting;
import models.jdbc.User;
import models.jpa.JPAUser;
import org.junit.Test;
import service.AdminService;
import static org.junit.jupiter.api.Assertions.*;

public class createOperatorTest {
    @Test
    public void createOperatorTest(){
        AdminService adminService = new AdminService();
        JPAUser result = adminService.createOperator("test",90);
        assertNotNull(result);
        assertEquals("test", result.getUsername());
        assertEquals(90, result.getUserID());
    }

}
