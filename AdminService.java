package service;

import Database.jdbc.DBQueries;
import Database.jpa.insert;
import enums.CompanyRole;
import models.jpa.*;
import models.jpa.JPAUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Database.jpa.*;

/*Class that contains all the methods regarding the admin operations*/

public class AdminService {
    private static final Logger logger = LogManager.getLogger(AdminService.class);


    //create Rent a Car company
    public JPACompany createCompany(String name, int id) {
        JPACompany company = new JPACompany();
        company.setName(name);
        company.setCompanyID(id);
        if(insert.insertCompany(company)){
       logger.info("Company created successfully: " + company.getName());}
        return company;
    }
    //create operator
    public JPAUser createOperator(String username, int id) {
        JPAUser user = new JPAUser();
        user.setUsername(username);
        user.setRole(CompanyRole.OPERATOR);
        user.setUserID(id);
        if(insert.insertUser(user)){
        logger.info("Operator created with ID: " + id);}
        return user;
        }



        //authentication of admin
        public static boolean authenticate(int id, String username) {
            boolean exists = exist.adminExists(id, username);
            if (!exists) {
                logger.warn("Authentication failed for user {}", username);
            }
            return exists;
    }


}
