package V2;

import V2.Database.DBQueries;
import V2.Models.Company;
import V2.Models.User;
import V2.utils.enums.Role;

public class Demo {

    public static void main(String[] args) {

        // 1. Create a Company object
        Company company = new Company();
        company.setCompanyID(4);
        company.setName("V5");
        // 2. Insert into the database
        int query = DBQueries.insertCompany(company);
        // 3. Check result
        if (query > 0) {
            System.out.println("Company inserted successfully!");
            System.out.println("Company ID: " + company.getCompanyID());
            System.out.println("Name: " + company.getName());
        } else {
            System.out.println("Failed to insert company.");
        }

        //insertUser
        User user = new User();
        user.setUserID(3);
        user.setRole(Role.ADMIN);
        user.setUsername("Third Operator");
        int query2 = DBQueries.insertUser(user);
        if (query2 > 0) {
            System.out.println("User inserted successfully!");
            System.out.println("User ID: " + user.getUserID());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());

        } else {
            System.out.println("Failed to insert user.");
        }

    }
}
