package models.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*Company Entity*/

@Entity
@Table(name = "COMPANY")
public class JPACompany {
    @Id
    @Column(name = "company_id")
    private int companyID;
    @Column(name = "company_name")
    private String name;

    //constructor
    public JPACompany(){};
    public JPACompany(int companyID, String name) {
        this.companyID = companyID;
        this.name = name;
    }
    // Getters n setters
    public int getCompanyID() { return companyID; }
    public void setCompanyID(int companyID) { this.companyID = companyID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
