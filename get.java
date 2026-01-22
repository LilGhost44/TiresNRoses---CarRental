package Database.jpa;

import enums.RentalStatus;
import jakarta.persistence.EntityManager;
import models.jpa.*;
import models.jpa.RentalHistory;
import java.util.List;

/*Class that contains all the methods regarding the getting of entities*/

public class get {
    public static JPARental getRentalById(int rentalId) {
        EntityManager em = jpa.getEntityManager();

        JPARental rental = em.find(JPARental.class, rentalId);

        em.close();
        return rental;
    }
    public static JPACar getCarById(JPACar carId) {
        EntityManager em = jpa.getEntityManager();

        JPACar car = em.find(JPACar.class, carId);

        em.close();
        return car;
    }
    public static RentalStatus getRentalStatus(int rentalId) {
        EntityManager em = jpa.getEntityManager();

        JPARental rental = em.find(JPARental.class, rentalId);
        RentalStatus status = rental != null ? rental.getRentalStatus() : null;

        em.close();
        return status;
    }
    public static List<JPACar> getAvailableCars() {
        return reports.findAvailableCars();
    }
    public static List<JPARentedCarStatistics> getRentedCarStatistics() {
        return reports.reportRentedCarStatistics();
    }
    public static List<ClientRating> getClientRating() {
        return reports.reportClientRatings();
    }
    public static List<RentalHistory> getRentalHistory() {
        return reports.reportRentalHistory();
    }
    public static List<OperatorActivity> getOperatorActivity() {
        return reports.reportOperatorActivity();
    }



}
