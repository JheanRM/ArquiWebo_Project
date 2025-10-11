package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "clientplan")
public class ClientPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "StartPlan",nullable = false,length = 35)
    private LocalDate startPlan;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "Plan_idPlan")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "PaymentMethod_id")
    private PaymentMethod paymentMethod;

    public ClientPlan() {
    }

    public ClientPlan(int id, LocalDate startPlan, Client client, Plan plan, PaymentMethod paymentMethod) {
        this.id = id;
        this.startPlan = startPlan;
        this.client = client;
        this.plan = plan;
        this.paymentMethod = paymentMethod;
    }

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
