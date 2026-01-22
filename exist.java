package Database.jpa;

import enums.CompanyRole;
import jakarta.persistence.EntityManager;
import models.jpa.JPACar;
import models.jpa.JPAConditionReport;
import models.jpa.JPARental;

/*Class that contains all the methods regarding the existing of entities*/

public class exist {
    public static boolean adminExists(int id, String username) {
        EntityManager em = jpa.getEntityManager();

        boolean exists = !em.createQuery(
                "SELECT u.userID FROM JPAUser u " +
                        "WHERE u.userID = :id " +
                        "AND u.username = :username " +
                        "AND u.companyRole = :companyRole")
                .setParameter("id", id)
                .setParameter("username", username)
                .setParameter("companyRole", CompanyRole.ADMIN)
                .setMaxResults(1)
                .getResultList()
                .isEmpty();

        em.close();
        return true;
    }
    public static boolean operatorExists(int id, String username) {
        EntityManager em = jpa.getEntityManager();

        boolean exists = !em.createQuery(
                "SELECT u.userID FROM JPAUser u " +
                        "WHERE u.userID = :id " +
                        "AND u.username = :username " +
                        "AND u.companyRole = :role"
        )
                .setParameter("id", id)
                .setParameter("username", username)
                .setParameter("role", CompanyRole.OPERATOR)
                .setMaxResults(1)
                .getResultList()
                .isEmpty();

        em.close();
        return exists;
    }
    public static boolean rentalExists(int rentalId) {
        EntityManager em = jpa.getEntityManager();
        boolean exists = em.find(JPARental.class, rentalId) != null;
        em.close();
        return exists;
    }
    public static boolean conditionReportExists(int reportId) {
        EntityManager em = jpa.getEntityManager();

        boolean exists = em.find(JPAConditionReport.class, reportId) != null;

        em.close();
        return exists;
    }
    public static boolean carExists(int carId) {
        EntityManager em = jpa.getEntityManager();

        boolean exists = em.find(JPACar.class, carId) != null;

        em.close();
        return exists;
    }
    public static boolean characteristicsExist(int carId) {
        EntityManager em = jpa.getEntityManager();

        boolean exists = !em.createQuery(
                "SELECT cc.car.id FROM CarCharacteristics cc WHERE cc.car.id = :carId"
        )
                .setParameter("carId", carId)
                .setMaxResults(1)
                .getResultList()
                .isEmpty();

        em.close();
        return exists;
    }
}
