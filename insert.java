package Database.jpa;

import Database.jdbc.DatabaseConnection;
import jakarta.persistence.EntityManager;
import models.jdbc.*;
import models.jpa.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*Class that contains all the methods regarding the insertion of entities*/

public class insert {
   public static boolean insertCar(JPACar car, JPACarCharacteristics characteristics) {
       try{EntityManager em = jpa.getEntityManager();
           em.getTransaction().begin();
           em.persist(car);
           characteristics.setCar(car);
           em.persist(characteristics);
           em.getTransaction().commit();
           em.close();
           return true; // success
       }catch (Exception e) {e.printStackTrace();
           return false; // failure
       }
   }
    public static boolean insertCompany(JPACompany company) {
        try{EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
        em.close();
        return true; // success
    }catch (Exception e) {e.printStackTrace();
            return false; // failure
        }
    }
    public static boolean insertUser(JPAUser user) {
       try{ EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return true; // success
    }catch (Exception e) {e.printStackTrace();
        return false; // failure
    }
    }
    public static boolean insertClient(JPAClient client) {
       try{ EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
        return true; // success
    }catch (Exception e) {e.printStackTrace();
        return false; // failure
    }
    }
    public static boolean insertRental(JPARental rental) {
        try{EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        em.persist(rental);
        em.getTransaction().commit();
        em.close();
            return true; // success
        }catch (Exception e) {e.printStackTrace();
            return false; // failure
    }
    }
    public static boolean insertConditionReport(JPAConditionReport startReport) {
        try {
            EntityManager em = jpa.getEntityManager();
            em.getTransaction().begin();
            em.persist(startReport);
            em.getTransaction().commit();
            em.close();
            return true; // success
        }catch (Exception e) {e.printStackTrace();
            return false; // failure
        }
    }


}
