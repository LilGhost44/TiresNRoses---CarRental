package Models;

public class ClientRating {
    private int clientId;
    private String clientName;
    private int rating;

    public ClientRating(int clientId, String clientName, int rating) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.rating = rating;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public int getRating() {
        return rating;
    }
}
