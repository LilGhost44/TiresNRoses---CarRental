package testing.serviceTesting;

import models.jdbc.Company;
import models.jpa.JPACompany;
import org.junit.Test;
import service.AdminService;
import static org.junit.jupiter.api.Assertions.*;

public class createCompanyTest {
    @Test
    public void createCompanyTest(){
        AdminService adminService = new AdminService();
        JPACompany result = adminService.createCompany("test",300);
        assertNotNull(result);
        assertEquals("test", result.getName());
        assertEquals(300, result.getCompanyID());

    }

}
