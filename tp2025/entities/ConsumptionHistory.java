package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "consumptionhistory")
public class ConsumptionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Type",nullable = false,length = 35)
    private String type;
    @Column(name = "Message",nullable = false,length = 35)
    private String message;
    @Column(name = "DateTimeStar",nullable = false,length = 35)
    private LocalDate datetimeStar;
    @Column(name = "consumption",nullable = false,length = 35)
    private String consumption;
    @Column(name = "DateTimeEnd",nullable = false,length = 35)
    private LocalDate datetimeEnd;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public ConsumptionHistory() {
    }

    public ConsumptionHistory(int id, String type, String message, LocalDate datetimeStar, String consumption, LocalDate datetimeEnd, Device device) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.datetimeStar = datetimeStar;
        this.consumption = consumption;
        this.datetimeEnd = datetimeEnd;
        this.device = device;
    }

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
