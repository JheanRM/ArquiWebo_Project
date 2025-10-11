package pe.edu.upc.tp2025.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tp2025.entities.Client;
import pe.edu.upc.tp2025.entities.PaymentMethod;
import pe.edu.upc.tp2025.entities.Plan;

import java.time.LocalDate;
import java.util.Date;

public class ClientPlanDTO {
    private int id;
    private LocalDate startPlan;
    private Client client;
    private Plan plan;
    private PaymentMethod paymentMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(LocalDate startPlan) {
        this.startPlan = startPlan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
