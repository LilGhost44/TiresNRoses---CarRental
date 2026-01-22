package Database.jpa;

import Database.jdbc.DBQueries;
import enums.RentalStatus;
import jakarta.persistence.EntityManager;
import models.jpa.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/*Class that contains all the methods regarding the logging of data*/

public class log {

    private static final Logger logger = LogManager.getLogger(log.class);

    public void logExpiredRentalsForOperator(int operatorId) {
        EntityManager em = jpa.getEntityManager();
        Logger logger = LogManager.getLogger("ExpiredRentals");

        List<JPARental> results = em.createQuery(
                "SELECT new ExpiredRentalInfo(" +
                        " r.id, cl.name, c.brand, c.model, r.expectedRentDate" +
                        ") " +
                        "FROM Rental r " +
                        "JOIN r.client cl " +
                        "JOIN r.car c " +
                        "WHERE r.operator.id = :operatorId " +
                        "AND r.expectedRentDate < CURRENT_DATE " +
                        "AND r.rentalStatus = :status",
                JPARental.class
        )
                .setParameter("operatorId", operatorId)
                .setParameter("status", RentalStatus.ACTIVE)
                .getResultList();

        if (results.isEmpty()) {
            logger.info("No expired rentals for operator {}", operatorId);
        } else {
            results.forEach(r ->
                    logger.warn(
                            "EXPIRED RENTAL -> Rental #{} | Client: {} | Car: {} | Expected return: {}",
                            r.getRentalID(),
                            r.getClientID(),
                            r.getCarID(),
                            r.getExpectedReturnDate()
                    )
            );
        }

        em.close();
    }
    public void logRiskyClients() {
        EntityManager em = jpa.getEntityManager();
        Logger logger = LogManager.getLogger("RiskyClients");

        List<JPAClient> clients = em.createQuery(
                "SELECT c FROM CompanyClient c WHERE c.rating >= :limit",
                JPAClient.class
        )
                .setParameter("limit", 5)
                .getResultList();

        if (clients.isEmpty()) {
            logger.info("No risky clients found.");
        } else {
            clients.forEach(c ->
                    logger.warn(
                            "RISKY CLIENT -> {} (ID: {}) | Rating: {}",
                            c.getName(),
                            c.getClientID(),
                            c.getRating()
                    )
            );
        }

        em.close();
    }
}
