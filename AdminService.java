package V2.Service;

import V2.utils.enums.*;
import V2.Models.*;
import V2.Database.DBQueries;


public class AdminService {
    //create Rent a Car company
    public Company createCompany(String name,int id) {
        Company company = new Company();
        company.setName(name);
        DBQueries.insertCompany(company);
        company.setCompanyID(id);
        System.out.println("Company created successfully: " + company.getName());
        return company;
    }
    //create operator
    public User createOperator(String username, int id) {
        User user = new User();
        user.setUsername(username);
        user.setRole(Role.OPERATOR);
        user.setUserID(id);
        DBQueries.insertUser(user);
        System.out.println("Operator created with ID: " + id);
        return user;
    }


}
