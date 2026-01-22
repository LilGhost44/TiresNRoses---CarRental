package Database.jpa;

import enums.CarStatus;
import enums.CompanyRole;
import jakarta.persistence.EntityManager;
import models.jpa.RentalHistory;
import models.jpa.ClientRating;
import models.jpa.JPACar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.jpa.*;


import java.util.List;

/*Class that contains all the methods regarding the reports of entities*/

public class reports {

    private static final Logger logger = LogManager.getLogger(reports.class);

    public static List<JPACar> findAvailableCars() {
        EntityManager em = jpa.getEntityManager();
        List<JPACar> cars = em.createQuery(
                "SELECT c FROM JPACar c WHERE c.carStatus = :status",
                JPACar.class)
                .setParameter("status", CarStatus.AVAILABLE)
                .getResultList();
        em.close();
        return cars;
    }
    public static List<RentalHistory> reportRentalHistory() {
        EntityManager em = jpa.getEntityManager();
       /* List<RentalHistory> history = em.createQuery(
                "SELECT new models.jpa.RentalHistory(" +
                        " r.rentalID, c.brand, c.model, cl.name, " +
                        " r.rentDate, r.expectedReturnDate, r.returnDate, " +
                        " r.totalCost, r.rentalStatus" +
                        ") " +
                        "FROM JPARental r " +
                        "JOIN r.carID c " +
                        "JOIN r.clientID cl " +
                        "ORDER BY r.rentDate DESC",
                RentalHistory.class
        ).getResultList();*/
        List<RentalHistory> history = em.createQuery(
                "SELECT new models.jpa.RentalHistory(" +
                        " r.rentalID, " +
                        " c.brand, " +
                        " c.model, " +
                        " cl.name, " +
                        " r.rentDate, " +
                        " r.expectedReturnDate, " +
                        " r.returnDate, " +
                        " r.totalCost, " +
                        " r.rentalStatus" +
                        ") " +
                        "FROM JPARental r " +
                        "JOIN r.carID c " +
                        "JOIN r.clientID cl " +
                        "ORDER BY r.rentDate DESC",
                RentalHistory.class
        ).getResultList();
        logger.info("=== RENTAL HISTORY ===");
        logger.info("Rental history loaded: " + history.size());
        em.close();
        return history;
    }
    public static List<OperatorActivity> reportOperatorActivity() {
        EntityManager em = jpa.getEntityManager();
        List<OperatorActivity> activity = em.createQuery(
                "SELECT new models.jpa.OperatorActivity(" +
                        " u.userID, u.username, r.rentalID, " +
                        " r.rentDate, r.returnDate, " +
                        " r.totalCost, r.rentalStatus" +
                        ") " +
                        "FROM JPAUser u " +
                        "JOIN u.rentals r " +
                        "WHERE u.companyRole = :role " +
                        "ORDER BY u.userID, r.rentDate",
                OperatorActivity.class
        )
                .setParameter("role", CompanyRole.OPERATOR)
                .getResultList();

        logger.info("=== OPERATOR ACTIVITY ===");
        logger.info("Operator activity loaded: " + activity.size());
        em.close();
        return activity;
    }
    public static List<ClientRating> reportClientRatings() {
        EntityManager em = jpa.getEntityManager();

        List<ClientRating> ratings = em.createQuery(
                "SELECT new models.jpa.ClientRating(c.clientID, c.name, c.rating) " +
                        "FROM JPAClient c " +
                        "ORDER BY c.rating DESC",
                ClientRating.class
        ).getResultList();
        logger.info("=== CLIENT RATINGS ===");
        logger.info("Client ratings loaded: " + ratings.size());

        em.close();
        return ratings;
    }
    public static List<JPARentedCarStatistics> reportRentedCarStatistics() {
        EntityManager em = jpa.getEntityManager();

        List<JPARentedCarStatistics> stats = em.createQuery(
                "SELECT new models.jpa.JPARentedCarStatistics(" +
                        " c.brand, c.model, COUNT(r)" +
                        ") " +
                        "FROM JPARental r " +
                        "JOIN r.carID c " +
                        "GROUP BY c.brand, c.model " +
                        "ORDER BY COUNT(r) DESC",
                JPARentedCarStatistics.class
        ).getResultList();

        logger.info("=== RENTED CAR STATISTICS ===");
        logger.info("Stats loaded: " + stats.size());

        em.close();
        return stats;
    }
}
