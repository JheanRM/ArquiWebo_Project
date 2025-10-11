package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlan;

    @Column(name = "NamePlan",nullable = false,length = 35)
    private String namePlan;
    @Column(name = "Price",nullable = false,length = 35)
    private Double price;
    @Column(name = "Duration",nullable = false,length = 35)
    private int duration;
    @Column(name = "Characteristics",nullable = false,length = 35)
    private String characteristics;
    @Column(name = "MaxDevice",nullable = false,length = 35)
    private int maxDevice;

    public Plan() {
    }

    public Plan(int idPlan, String namePlan, Double price, int duration, String characteristics, int maxDevice) {
        this.idPlan = idPlan;
        this.namePlan = namePlan;
        this.price = price;
        this.duration = duration;
        this.characteristics = characteristics;
        this.maxDevice = maxDevice;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public int getMaxDevice() {
        return maxDevice;
    }

    public void setMaxDevice(int maxDevice) {
        this.maxDevice = maxDevice;
    }
}
