package pe.edu.upc.tp2025.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tp2025.entities.Client;

public class TransactionsDTO {
    private int id;
    private Double points;
    private String typeTransactions;
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getTypeTransactions() {
        return typeTransactions;
    }

    public void setTypeTransactions(String typeTransactions) {
        this.typeTransactions = typeTransactions;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
