package Database.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*Class for main EntityManager*/

public class jpa {
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("CarRentalPU");
        }
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null) emf.close();
    }
}