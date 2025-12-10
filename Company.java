package V2.Models;

public class Company {
    private int companyID;
    private String name;

    //Default Constructor and Constructor
    public Company() {}
    public Company(int companyID, String name) {
        this.companyID = companyID;
        this.name = name;
    }
    // Getters n setters
    public int getCompanyID() { return companyID; }
    public void setCompanyID(int companyID) { this.companyID = companyID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
