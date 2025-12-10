package V2.Database;
import V2.Models.*;
import java.sql.*;
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
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, user.getUserID());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getRole().name());
            int rows = stmt.executeUpdate();
            if(rows>0){
                return user.getUserID();  // return the ID we inserted manually
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }
    public static void insertClient(Client client) {
        String sql = "INSERT INTO clients(full_name, phone, email, license_number, rating) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, client.getName());
            stmt.setString(2, client.getPhone());
            stmt.setString(3, client.getEmail());
            stmt.setDouble(5, client.getRating());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRental(Rental rental){};
    public static void insertConditionReport(ConditionReport startReport){};
    public static void updateCarStatus(int carID, String status){};
    public static void insertDamage(Damage damage){};
    public static void completeRental(int rentalID, ConditionReport endReport, List<Damage>damages){};
    public static void insertCar(Car car){};
    public static void insertCarCharacteristics(CarCharacteristics ch){};

}
