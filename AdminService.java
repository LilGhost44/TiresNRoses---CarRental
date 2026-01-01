package service;

import Database.DBQueries;
import Models.Company;
import Models.User;
import enums.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AdminService {
    private static final Logger logger = LogManager.getLogger(AdminService.class);

    //create Rent a Car company
    public Company createCompany(String name, int id) {
        Company company = new Company();
        company.setName(name);
        DBQueries.insertCompany(company);
        company.setCompanyID(id);
       logger.info("Company created successfully: " + company.getName());
        return company;
    }
    //create operator
    public User createOperator(String username, int id) {
        User user = new User();
        user.setUsername(username);
        user.setRole(Role.OPERATOR);
        user.setUserID(id);
        DBQueries.insertUser(user);
        logger.info("Operator created with ID: " + id);
        return user;
    }


        //authentication of admin

        public static boolean authenticate(int id, String username) {
            boolean exists = DBQueries.adminExists(id, username);
            if (!exists) {
                logger.warn("Authentication failed for user {}", username);
            }
            return exists;

    }


}
