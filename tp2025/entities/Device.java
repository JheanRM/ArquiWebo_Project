package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name", nullable = false,length = 35)
    private String name;
    @Column(name = "InstalationDate",nullable = false,length = 35)
    private Integer instalationDate;

    @ManyToOne
    @JoinColumn(name ="cliente_id",nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "tipodevice_id",nullable = false)
    private TypeDevice typeDevice;

    public Device() {
    }

    public Device(int id, String name, Integer instalationDate, Client client, TypeDevice typeDevice) {
        this.id = id;
        this.name = name;
        this.instalationDate = instalationDate;
        this.client = client;
        this.typeDevice = typeDevice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInstalationDate() {
        return instalationDate;
    }

    public void setInstalationDate(Integer instalationDate) {
        this.instalationDate = instalationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypeDevice getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(TypeDevice typeDevice) {
        this.typeDevice = typeDevice;
    }
}
