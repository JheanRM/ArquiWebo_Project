package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "transacciones")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Points",nullable = false,length = 35)
    private Double points;
    @Column(name = "TypeTransactions",nullable = false,length = 35)
    private String typeTransactions;

    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    private Client client;

    public Transactions() {
    }

    public Transactions(int id, Double points, String typeTransactions, Client client) {
        this.id = id;
        this.points = points;
        this.typeTransactions = typeTransactions;
        this.client = client;
    }

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
