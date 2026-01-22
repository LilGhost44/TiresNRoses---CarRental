package testing.serviceTesting;

import Database.jpa.*;
import jakarta.persistence.EntityManager;
import enums.RentalStatus;
import enums.ReportStage;
import models.jpa.*;
import org.junit.Test;
import service.OperatorService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class endRentalTest {
    @Test
    public void endRentalTest() throws Exception {
        EntityManager em = jpa.getEntityManager();
        JPARental endRental  = new JPARental(10,em.find(JPAClient.class, 100),em.find(JPACar.class, 1),em.find(JPAUser.class, 90), LocalDate.of(2025,01,
                17),LocalDate.of(2026,01,20),LocalDate.of(1111,11,
                11),
                0, RentalStatus.ACTIVE,0);
        JPAConditionReport endConditionReport = new JPAConditionReport(11,10,"Minor Scratches",
                "None","Used","None", ReportStage.END);
        OperatorService operatorService = new OperatorService();
       operatorService.endRental(endRental,endConditionReport,LocalDate.of(2026,01,21),
                120.6);
        assertEquals("COMPLETED", get.getRentalStatus(10));


    }
}
