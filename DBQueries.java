package Database;

import Models.*;
import controller.StartRentalController;
import enums.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBQueries {
    private static final Logger logger = LogManager.getLogger(DBQueries.class);


    public static int insertCompany(Company company) {
        String sql = "INSERT INTO Company (company_id, company_name) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, company.getCompanyID());
            stmt.setString(2, company.getName());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return company.getCompanyID();  // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // error
    }

    public static int insertUser(User user) {
        String sql = "INSERT INTO CompanyUsers (user_id, username ,company_role) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserID());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getRole().name());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return user.getUserID();  // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }

    public static int insertClient(Client client) {
        String sql = "INSERT INTO CompanyClient(client_id, client_name, client_phone, client_email, client_rating) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, client.getClientID());
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getPhone());
            stmt.setString(4, client.getEmail());
            stmt.setDouble(5, client.getRating());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return client.getClientID();  // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }

    public static int insertRental(Rental rental) {
        String sql = "INSERT INTO Rental(rental_id, client_id, car_id, operator_id,rent_date,expected_rent_date, return_date, init_mileage, return_mileage, total_cost, rental_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rental.getRentalID());
            stmt.setInt(2, rental.getClientID());
            stmt.setInt(3, rental.getCarID());
            stmt.setInt(4, rental.getOperatorID());
            stmt.setDate(5, Date.valueOf(rental.getRentDate()));
            stmt.setDate(6, Date.valueOf(rental.getExpectedReturnDate()));
            stmt.setDate(7, Date.valueOf(rental.getReturnDate()));
            stmt.setDouble(8, rental.getInitialMileage());
            stmt.setDouble(9, rental.getReturnMileage());
            stmt.setDouble(10, rental.getTotalCost());
            stmt.setString(11, String.valueOf(rental.getRentalStatus())); //!

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return rental.getRentalID();  // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }

    public static int insertCar(Car car) {
        {
            String sql = "INSERT INTO Car(car_id, brand, car_model, car_year, car_class, car_category, smoking_allowed, daily_rate, km_rate, mileage, car_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, car.getCarID());
                stmt.setString(2, car.getBrand());
                stmt.setString(3, car.getModel());
                stmt.setInt(4, car.getYear());
                stmt.setString(5, String.valueOf(car.getCarClass()));
                stmt.setString(6, String.valueOf(car.getCategory()));
                stmt.setBoolean(7, car.isSmokingAllowed());
                stmt.setDouble(8, car.getDailyRate());
                stmt.setDouble(9, car.getKmRate());
                stmt.setDouble(10, car.getMileage());
                stmt.setString(11, String.valueOf(car.getStatus()));


                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    return car.getCarID();  // return the ID we inserted manually
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1; // failed
        }
    }

    ;

    //insertCarCharacteristics
    public static int insertCarCharacteristics(CarCharacteristics characteristic) {
        String sql = "INSERT INTO CarCharacteristics(car_id, fuel_type, gear_box, horse_power, color) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, characteristic.getCarID());
            stmt.setString(2, characteristic.getFuelType());
            stmt.setString(3, characteristic.getGearBox());
            stmt.setInt(4, characteristic.getHorsepower());
            stmt.setString(5, characteristic.getColor());


            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return 1; // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }

    public static int insertConditionReport(ConditionReport startReport) {
        String sql = "INSERT INTO ConditionReport(report_id, rental_id, scratches, interior_damage, tire_condition, notes, report_stage) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, startReport.getReportID());
            stmt.setInt(2, startReport.getRentalID());
            stmt.setString(3, startReport.getScratches());
            stmt.setString(4, startReport.getInteriorDamage());
            stmt.setString(5, startReport.getTireCondition());
            stmt.setString(6, startReport.getNotes());
            stmt.setString(7, String.valueOf(startReport.getStage()));


            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return startReport.getReportID(); // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }

    public static int insertDamage(Damage damage) {
        String sql = "INSERT INTO Damage(damage_id, rental_id, cost, description) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, damage.getDamageID());
            stmt.setInt(2, damage.getRentalID());
            stmt.setDouble(3, damage.getCost());
            stmt.setString(4, damage.getDescription());


            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return damage.getDamageID(); // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }

    public static int updateCarStatus(int carID, String status) {

        String sql = "UPDATE Car SET car_status = ? WHERE car_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, carID);

            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // error
    }

    public static int completeRental(Rental rental, ConditionReport endReport) {
        String sql = "INSERT INTO ConditionReport(report_id, rental_id, scratches, interior_damage, tire_condition, notes, report_stage) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, endReport.getReportID());
            stmt.setInt(2, endReport.getRentalID());
            stmt.setString(3, endReport.getScratches());
            stmt.setString(4, endReport.getInteriorDamage());
            stmt.setString(5, endReport.getTireCondition());
            stmt.setString(6, endReport.getNotes());
            stmt.setString(7, String.valueOf(endReport.getStage()));

            int penalty = 0;
            if (rental.getReturnDate().isAfter(rental.getExpectedReturnDate())) {
                penalty += 2;
            }

            DBQueries.increaseClientRating(rental.getClientID(), penalty); //increase client rate

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return endReport.getReportID(); // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }

    ;

    //update rental status to completed
    public static int updateRentalStatus(int rentalID) {

        String sql = "UPDATE Rental SET rental_status = ? WHERE rental_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, String.valueOf(RentalStatus.COMPLETED));
            stmt.setInt(2, rentalID);

            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // error
    }

    //increaseClientRating
    public static void increaseClientRating(int clientId, int amount) {

        String sql = "UPDATE CompanyClient SET client_rating = client_rating + ? WHERE client_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, amount);
            stmt.setInt(2, clientId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update rental returnDate
    public static int updateReturnDate(int rentalID, LocalDate returnDate) {

        String sql = "UPDATE Rental SET return_date = ? WHERE rental_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(2, rentalID);
            stmt.setDate(1, Date.valueOf(returnDate));

            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // error
    }
    //updateMileage for endRental
    public static int updateMileage(int rentalID, int endMileage) {

        String sql = "UPDATE Rental SET init_mileage = ? WHERE rental_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(2, rentalID);
            stmt.setInt(1, endMileage);

            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // error
    }
    //updateCost for endRental
    public static int updateCost(int rentalID, Double totalCost) {

        String sql = "UPDATE Rental SET total_cost = ? WHERE rental_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(2, rentalID);
            stmt.setDouble(1, totalCost);

            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // error
    }

    //reportAvailableCars
    public static List<Car> reportAvailableCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT car_id, brand, car_model ,daily_rate FROM Car WHERE car_status = 'AVAILABLE' ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            logger.info("=== AVAILABLE CARS ===");
            while (rs.next()) {
                Car car = new Car();
                car.setCarID(rs.getInt("car_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("car_model"));
                car.setDailyRate(rs.getDouble("daily_rate"));

                cars.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    //reportRentalHistory
    public static List<RentalHistory> reportRentalHistory () {
       List<RentalHistory> history = new ArrayList<>();
        String sql2 = "SELECT r.rental_id, c.brand, c.car_model, cl.client_name, r.rent_date, r.expected_rent_date, r.return_date, r.total_cost, r.rental_status FROM Rental r JOIN Car c ON r.car_id = c.car_id JOIN CompanyClient cl ON r.client_id = cl.client_id ORDER BY r.rent_date DESC ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql2)) {

            logger.info("=== RENTAL HISTORY ===");

            while (rs.next()) {
                RentalHistory row = new RentalHistory(
                        rs.getInt("rental_id"),
                        rs.getString("brand"),
                        rs.getString("car_model"),
                        rs.getString("client_name"),
                        rs.getDate("rent_date").toLocalDate(),
                        rs.getDate("expected_rent_date").toLocalDate(),
                        rs.getDate("return_date").toLocalDate(),
                        rs.getDouble("total_cost"),
                        rs.getString("rental_status")

                );
                history.add(row);
            }

            logger.info("Rental history loaded: " + history.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
    //reportOperatorActivity
    public static List<OperatorActivity> reportOperatorActivity() {
      List<OperatorActivity> activity = new ArrayList<>();
        String sql = "SELECT u.user_id, u.username, r.rental_id, r.rent_date, r.return_date, r.total_cost, r.rental_status FROM CompanyUsers u JOIN Rental r ON u.user_id = r.operator_id WHERE u.company_role = 'OPERATOR' ORDER BY u.user_id, r.rent_date ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            logger.info("=== OPERATOR ACTIVITY ===");

            while (rs.next()) {
                OperatorActivity row = new OperatorActivity(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getInt("rental_id"),
                        rs.getDate("rent_date").toLocalDate(),
                        rs.getDate("return_date").toLocalDate(),
                        rs.getDouble("total_cost"),
                        rs.getString("rental_status")
                );
                activity.add(row);
            }

            logger.info("Operator activity loaded: " + activity.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activity;
    }
    //reportClientRatings
    public static List<ClientRating> reportClientRatings() {
      List<ClientRating> ratings = new ArrayList<>();
        String sql = "SELECT client_id, client_name,client_rating FROM CompanyClient ORDER BY client_rating DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            logger.info("=== CLIENT RATINGS ===");

            while (rs.next()) {
                ClientRating cr = new ClientRating(
                        rs.getInt("client_id"),
                        rs.getString("client_name"),
                        rs.getInt("client_rating")
                );
                ratings.add(cr);
            }

            logger.info("Client ratings loaded: " + ratings.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }
    //reportRentedCarStatistics
    public static List<RentedCarStatistics> reportRentedCarStatistics() {
        List<RentedCarStatistics> stats = new ArrayList<>();
        String sql = "SELECT c.brand,c.car_model, COUNT(r.rental_id) AS times_rented FROM Rental r JOIN Car c ON r.car_id = c.car_id GROUP BY c.brand, c.car_model ORDER BY times_rented DESC ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            logger.info("=== RENTED CAR STATISTICS ===");

            while (rs.next()) {
                RentedCarStatistics row = new RentedCarStatistics(
                        rs.getString("brand"),
                        rs.getString("car_model"),
                        rs.getInt("times_rented")
                );
                stats.add(row);
            }

            logger.info("Stats loaded: " + stats.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }
    //admin exists
    public static boolean adminExists(int id, String username) {

        String sql = "SELECT 1 FROM companyusers WHERE user_id = ? AND username = ? AND company_role='ADMIN' ";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, username);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //operator exists
    public static boolean operatorExists(int id, String username) {

        String sql = "SELECT 1 FROM companyusers WHERE user_id = ? AND username = ? AND company_role='OPERATOR' ";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, username);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Rental getRentalById(int rentalId) {
        String sql = "SELECT * FROM Rental WHERE rental_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rentalId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Rental(rs.getInt("rental_id"), rs.getInt("client_id"), rs.getInt("car_id"), rs.getInt("operator_id"), rs.getDate("rent_date").toLocalDate(), rs.getDate("expected_rent_date").toLocalDate(), rs.getDate("return_date").toLocalDate() ,rs.getInt("init_mileage"), RentalStatus.valueOf(rs.getString("rental_status")),rs.getDouble("total_cost"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Car getCarById(int carId) {

        String sql = "SELECT * FROM Car WHERE car_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, carId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Car(
                        rs.getInt("car_id"),
                        rs.getString("brand"),
                        rs.getString("car_model"),
                        rs.getInt("car_year"),
                        CarClass.valueOf(rs.getString("car_class")),
                        Category.valueOf(rs.getString("car_category")),
                        rs.getBoolean("smoking_allowed"),
                        rs.getDouble("daily_rate"),
                        rs.getDouble("km_rate"),
                        rs.getInt("mileage"),
                        Status.valueOf(rs.getString("car_status"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //log expired rentals when operator log in
    public static void logExpiredRentalsForOperator(int operatorId) {

        String sql = "SELECT r.rental_id, cl.client_name, c.brand, c.car_model, r.expected_rent_date FROM Rental r JOIN CompanyClient cl ON r.client_id = cl.client_id JOIN Car c ON r.car_id = c.car_id WHERE r.operator_id = ?  AND r.expected_rent_date < SYSDATE AND r.rental_status = 'ACTIVE'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, operatorId);
            ResultSet rs = stmt.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                Logger logger = LogManager.getLogger("ExpiredRentals");

                logger.warn("EXPIRED RENTAL -> Rental #{} | Client: {} | Car: {} {} | Expected return: {}",
                        rs.getInt("rental_id"),
                        rs.getString("client_name"),
                        rs.getString("brand"),
                        rs.getString("car_model"),
                        rs.getDate("expected_rent_date")
                );
            }

            if (!found) {
                LogManager.getLogger("ExpiredRentals")
                        .info("No expired rentals for operator {}", operatorId);
            }

        } catch (SQLException e) {
            LogManager.getLogger("ExpiredRentals").error("Failed to check expired rentals", e);
        }
    }
public static void logRiskyClients(){
    String sql = "SELECT client_id, client_name, client_rating FROM CompanyClient WHERE client_rating >= 5";

    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        boolean found = false;
        Logger logger = LogManager.getLogger("RiskyClients");

        while (rs.next()) {
            found = true;
            logger.warn("RISKY CLIENT -> {} (ID: {}) | Rating: {}",
                    rs.getString("client_name"),
                    rs.getInt("client_id"),
                    rs.getInt("client_rating")
            );
        }

        if (!found) {
            logger.info("No risky clients found.");
        }

    } catch (SQLException e) {
        LogManager.getLogger("RiskyClients").error("Failed to check risky clients", e);
    }
}
}



