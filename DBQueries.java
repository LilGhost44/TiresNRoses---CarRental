package V2.Database;
import V2.Models.*;
import V2_1.RentalStatus;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class DBQueries {
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
        String sql = "INSERT INTO Rental(rental_id, client_id, car_id, operator_id,rent_date, return_date,expected_rent_date, init_mileage, return_mileage, total_cost, rental_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rental.getRentalID());
            stmt.setInt(2, rental.getClientID());
            stmt.setInt(3, rental.getCarID());
            stmt.setInt(4, rental.getOperatorID());
            stmt.setDate(5, Date.valueOf(rental.getRentDate()));
            stmt.setDate(6, Date.valueOf(rental.getReturnDate()));
            stmt.setDate(7, Date.valueOf(rental.getExpectedReturnDate()));
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

    public static int completeRental(Rental rental, ConditionReport endReport, List<Damage> damages) {
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
    public static int updateMileage(int rentalID, Double endMileage) {

        String sql = "UPDATE Rental SET return_mileage = ? WHERE rental_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(2, rentalID);
            stmt.setDouble(1, endMileage);

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
    public static void reportAvailableCars() {
        String sql = "SELECT car_id, brand, car_model ,daily_rate FROM Car WHERE car_status = 'AVAILABLE' ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== AVAILABLE CARS ===");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("car_id") + " | " +
                                rs.getString("brand") + " " +
                                rs.getString("car_model") + " | " +
                                rs.getDouble("daily_rate") + "/day"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //reportRentalHistory  check later
    public static void reportRentalHistory () {
        String sql2 = "SELECT r.rental_id, c.brand, c.car_model, cl.client_name, r.rent_date, r.expected_rent_date, r.return_date, r.total_cost, r.rental_status FROM Rental r JOIN Car c ON r.car_id = c.car_id JOIN CompanyClient cl ON r.client_id = cl.client_id ORDER BY r.rent_date DESC ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql2)) {

            System.out.println("=== RENTAL HISTORY ===");

            while (rs.next()) {
                System.out.println(
                        "Rental #" + rs.getInt("rental_id") +
                                " | Client: " + rs.getString("client_name") +
                                " | Car: " + rs.getString("brand") + " " + rs.getString("car_model") +
                                " | From: " + rs.getDate("rent_date") +
                                " | To: " + rs.getDate("return_date") +
                                " | Status: " + rs.getString("rental_status") +
                                " | Cost: " + rs.getDouble("total_cost")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //reportOperatorActivity almost working
    public static void reportOperatorActivity() {
        String sql = "SELECT u.user_id, u.username, r.rental_id, r.rent_date, r.return_date, r.total_cost, r.rental_status FROM CompanyUsers u JOIN Rental r ON u.user_id = r.operator_id WHERE u.company_role = 'OPERATOR' ORDER BY u.user_id, r.rent_date ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== OPERATOR ACTIVITY ===");

            while (rs.next()) {
                System.out.println(
                        "Operator: " + rs.getString("username") +
                                " | Rental #" + rs.getInt("rental_id") +
                                " | Date: " + rs.getDate("rent_date") +
                                " | Status: " + rs.getString("rental_status") +
                                " | Cost: " + rs.getDouble("total_cost")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //reportClientRatings
    public static void reportClientRatings() {
        String sql = "SELECT client_id, client_name,client_rating FROM CompanyClient ORDER BY client_rating DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== CLIENT RATINGS ===");

            while (rs.next()) {
                System.out.println(
                        "Client: " + rs.getString("client_name") +
                                " | Rating: " + rs.getInt("client_rating")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //reportRentedCarStatistics
    public static void reportRentedCarStatistics() {
        String sql = "SELECT c.brand,c.car_model, COUNT(r.rental_id) AS times_rented FROM Rental r JOIN Car c ON r.car_id = c.car_id GROUP BY c.brand, c.car_model ORDER BY times_rented DESC ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== RENTED CAR STATISTICS ===");

            while (rs.next()) {
                System.out.println(
                        rs.getString("brand") + " " +
                                rs.getString("car_model") +
                                " | Times rented: " + rs.getInt("times_rented")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
