package testing.serviceTesting;

import Database.jpa.*;
import Database.jpa.jpa;
import enums.RentalStatus;
import enums.ReportStage;
import jakarta.persistence.EntityManager;
import models.jdbc.ConditionReport;
import models.jdbc.Rental;
import models.jpa.*;
import org.junit.Test;
import service.OperatorService;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class startRentalTest {
    @Test
    public void startRentalTest() throws Exception {
        EntityManager em = jpa.getEntityManager();
        JPARental rental  = new JPARental(10,em.find(JPAClient.class, 100),em.find(JPACar.class, 1),em.find(JPAUser.class, 90), LocalDate.of(2025,01,
                17),LocalDate.of(2026,01,20),LocalDate.of(1111,11,
                11),
                0, RentalStatus.ACTIVE,0);
        JPAConditionReport conditionReport = new JPAConditionReport(11,10,"None",
                "None","Good","None", ReportStage.START);
        OperatorService operatorService = new OperatorService();
        operatorService.startRental(rental,conditionReport);
        assertTrue(exist.rentalExists(10));
        assertTrue(exist.conditionReportExists(11));
    }

}
