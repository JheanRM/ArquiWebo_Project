package pe.edu.upc.tp2025.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tp2025.entities.Device;

import java.time.LocalDate;

public class ConsumptionHistoryDTO {

    private int id;
    private String type;
    private String message;
    private LocalDate datetimeStar;
    private String consumption;
    private LocalDate datetimeEnd;
    private Device device;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDatetimeStar() {
        return datetimeStar;
    }

    public void setDatetimeStar(LocalDate datetimeStar) {
        this.datetimeStar = datetimeStar;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public LocalDate getDatetimeEnd() {
        return datetimeEnd;
    }

    public void setDatetimeEnd(LocalDate datetimeEnd) {
        this.datetimeEnd = datetimeEnd;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
