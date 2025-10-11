package pe.edu.upc.tp2025.dtos;

import jakarta.persistence.Column;

public class PlanDTO {
    private int idPlan;
    private String namePlan;
    private Double price;
    private int duration;
    private String characteristics;
    private int maxDevice;

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
