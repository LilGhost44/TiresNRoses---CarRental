package testing.serviceTesting;


import models.jpa.JPAClient;
import org.junit.Test;
import service.OperatorService;
import Database.jpa.*;

import static org.junit.jupiter.api.Assertions.*;

public class registerClientTest {
    @Test
    public void registerClientTest(){
        OperatorService operatorService = new OperatorService();
        JPAClient client = new JPAClient(100,"test","+306997885643","test@gmail.com",4.0);
        operatorService.registerClient(client);
        JPAClient test = other.findClientById(100);
        assertNotNull(test);
        assertEquals("test", test.getName());
        assertEquals(4.0, test.getRating());
    }
}
