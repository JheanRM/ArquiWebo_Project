package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "paymentmethod")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name="NameTitular",nullable = false,length = 35)
    private String nameTitular;
    @Column( name="NumberCard",nullable = false,length = 12)
    private Long numberCard;
    @Column(name = "cv",nullable = false,length = 3)
    private Integer cv;
    @Column(name = "expiration", nullable = false,length = 35)
    private LocalDate expiration;

    @ManyToOne
    @JoinColumn(name ="cliente_id")
    private Client client;

    public PaymentMethod() {
    }

    public PaymentMethod(Long id, String nameTitular, Long numberCard, Integer cv, LocalDate expiration, Client client) {
        this.id = id;
        this.nameTitular = nameTitular;
        this.numberCard = numberCard;
        this.cv = cv;
        this.expiration = expiration;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTitular() {
        return nameTitular;
    }

    public void setNameTitular(String nameTitular) {
        this.nameTitular = nameTitular;
    }

    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
    }

    public Integer getCv() {
        return cv;
    }

    public void setCv(Integer cv) {
        this.cv = cv;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
