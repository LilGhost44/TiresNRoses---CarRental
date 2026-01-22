package Database.jpa;

import Database.jdbc.DBQueries;
import Database.jdbc.DatabaseConnection;
import jakarta.persistence.EntityManager;
import models.jdbc.Client;
import models.jdbc.ConditionReport;
import models.jdbc.Rental;
import models.jpa.JPACar;
import models.jpa.JPAClient;
import models.jpa.JPAConditionReport;
import models.jpa.JPARental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*Class that contains all the methods regarding other operations on entities*/

public class other {
    public JPACar findById(int id) {
        EntityManager em = jpa.getEntityManager();
        JPACar car = em.find(JPACar.class, id);
        em.close();
        return car;
    }
    public static int completeRental(JPARental rental, JPAConditionReport endReport) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(endReport);
            int penalty = 0;
            if (rental.getReturnDate().isAfter(rental.getExpectedReturnDate())) {
                penalty += 2;
            }
            JPAClient client = em.find(JPAClient.class, rental.getClientID());
            if (client != null) {
                client.setRating(client.getRating() + penalty);
            }
            em.getTransaction().commit();
            return endReport.getReportID();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            em.close();
        }
    }
    public static int increaseClientRating(JPAClient clientId, int amount) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        JPAClient client = em.find(JPAClient.class, clientId);
        if (client != null) {
            client.setRating(client.getRating() + amount);
            return 1;
        }
        em.getTransaction().commit();
        em.close();
        return 0;
    }
    public static JPAClient findClientById(int clientId) {
        EntityManager em = jpa.getEntityManager();

        JPAClient client = em.find(JPAClient.class, clientId);

        em.close();
        return client;
    }
}
