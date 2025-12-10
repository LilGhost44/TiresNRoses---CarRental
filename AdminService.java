package V2.Service;

import V2.utils.enums.*;
import V2.Models.*;
import V2.Database.DBQueries;

public class AdminService {
    //create Rent a Car company
    public Company createCompany(String name) {
        Company company = new Company();
        company.setName(name);
        int generatedID = DBQueries.insertCompany(company);
        company.setCompanyID(generatedID);
        System.out.println("Company created successfully: " + company.getName());
        return company;
    }
    //create operator
    public int createOperator(String username) {
        User user = new User();
        user.setUsername(username);
        user.setRole(Role.OPERATOR);
        int id = DBQueries.insertUser(user);
        user.setUserID(id);
        System.out.println("Operator created with ID: " + id);
        return id;
    }


}
