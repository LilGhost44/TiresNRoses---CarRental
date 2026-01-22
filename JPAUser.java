package models.jpa;

import enums.CompanyRole;
import jakarta.persistence.*;

import java.util.List;

/*User Entity*/

@Entity
@Table(name = "COMPANYUSERS")
public class JPAUser {
    @Id
    @Column(name = "user_id")
    private int userID;
    @Column(name = "username")
    private String username;
    @Enumerated(EnumType.STRING)
    @Column(name = "COMPANY_ROLE")
    private CompanyRole companyRole;
    @OneToMany(mappedBy = "userID")
    private List<JPARental> rentals; //for loading operator activity

    //constructor
    public JPAUser(){};
    public JPAUser(int userID, String username,  CompanyRole role) {
        this.userID = userID;
        this.username = username;
        this.companyRole = companyRole;
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

    public CompanyRole getRole() {
        return companyRole;
    }

    public void setRole(CompanyRole role) {
        this.companyRole = role;
    }
}
