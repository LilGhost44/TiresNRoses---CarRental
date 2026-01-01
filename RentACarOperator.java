package Models;

import enums.Role;


public class RentACarOperator {
    //attributes
    private int userID;
    private String username;
    private Role role;  // OPERATOR
   //constructor
    public RentACarOperator(int userID, String username,  Role role) {
        this.userID = userID;
        this.username = username;
        this.role = role;
    }
    //Getters n Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
