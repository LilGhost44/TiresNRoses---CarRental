package models.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*Client Entity*/

@Entity
@Table(name = "COMPANYCLIENT")
public class JPAClient {
    @Id
    @Column(name = "client_id")
    private int clientID;
    @Column(name = "client_name")
    private String name;
    @Column(name = "client_phone")
    private String phone;
    @Column(name = "client_email")
    private String email;
    @Column(name = "client_rating")
    private double rating;

    //constructor
    public JPAClient(){};
    public JPAClient(int clientID, String name, String phone, String email, double rating) {
        this.clientID = clientID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
    }

    //Getters n Setters
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
}
