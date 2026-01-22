package Database.jpa;

import enums.RentalStatus;
import enums.CarStatus;
import jakarta.persistence.EntityManager;
import models.jpa.JPACar;
import models.jpa.JPARental;

import java.time.LocalDate;

/*Class that contains all the methods regarding the update of entities*/

public class update {
    public static int updateCarStatus(JPACar carID, CarStatus carStatus) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        JPACar car = em.find(JPACar.class, carID);
        if (car != null) {
            car.setStatus(carStatus);
        } else {
            System.out.println("Car with ID " + carID + " not found!");
            return 1;
        }
        em.getTransaction().commit();
        em.close();
        return 0;
    }
    public static int updateRentalStatus(int rentalID) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        JPARental rental = em.find(JPARental.class,rentalID);
        if (rental != null) {
            rental.setRentalStatus(RentalStatus.COMPLETED);
        } else {
            System.out.println("Rental with ID " + rentalID + " not found!");
            return 1;
        }
        em.getTransaction().commit();
        em.close();
        return 0;
    }
    public static int updateReturnDate(int rentalID, LocalDate returnDate) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        JPARental rental = em.find(JPARental.class, rentalID);
        if (rental != null) {
            rental.setReturnDate(returnDate);
            em.getTransaction().commit();
            em.close();
            return 1;
        }
        em.getTransaction().commit();
        em.close();
        return 0;
    }
    public static int updateMileage(int rentalID, int endMileage) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        JPARental rental = em.find(JPARental.class, rentalID);
        if (rental != null) {
            rental.setInitialMileage(endMileage);
            em.getTransaction().commit();
            em.close();
            return 1;
        }
        em.getTransaction().commit();
        em.close();
        return 0;
    }
    public static int updateMileageCar(JPACar carID, int extraMileage) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        JPACar car = em.find(JPACar.class, carID);
        if (car != null) {
            car.setMileage(car.getMileage() + extraMileage);
            em.getTransaction().commit();
            em.close();
            return 1; // updated
        }
        em.getTransaction().commit();
        em.close();
        return 0; // not found
    }
    public static int updateCost(int rentalID, Double totalCost) {
        EntityManager em = jpa.getEntityManager();
        em.getTransaction().begin();
        JPARental rental = em.find(JPARental.class, rentalID);
        if (rental != null) {
            rental.setTotalCost(totalCost);
            em.getTransaction().commit();
            em.close();
            return 1;
        }
        em.getTransaction().commit();
        em.close();
        return 0;
    }
}
