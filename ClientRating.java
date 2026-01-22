package models.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/*Client class for loading client ratings*/

public class ClientRating {

    private int clientID;
    private String name;
    private double rating;

    public ClientRating(int clientID, String name, double rating) {
        this.clientID = clientID;
        this.name = name;
        this.rating = rating;
    }

    public int getClientId() {
        return clientID;
    }

    public String getClientName() {
        return name;
    }

    public double getRating() {
        return rating;
    }
}
