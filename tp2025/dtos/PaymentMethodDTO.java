package pe.edu.upc.tp2025.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tp2025.entities.Client;

import java.time.LocalDate;
import java.util.Date;

public class PaymentMethodDTO {
    private Long id;
    private String nameTitular;
    private Long numberCard;
    private Integer cv;
    private LocalDate expiration;
    private Client client;

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


