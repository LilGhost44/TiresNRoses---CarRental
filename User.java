package Models;


import enums.Role;

public class User {
    //attributes
    private int userID;
    private String username;
    private Role role;

    //constructor
    public User(){};
    public User(int userID, String username,  Role role) {
        this.userID = userID;
        this.username = username;
        this.role = role;
    }

    //Getter n Setters
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