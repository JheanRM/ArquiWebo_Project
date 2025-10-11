package pe.edu.upc.tp2025.dtos;

import pe.edu.upc.tp2025.entities.Client;
import pe.edu.upc.tp2025.entities.TypeDevice;

import java.util.Date;

public class DeviceDTO {
    private int id;
    private String name;
    private Integer instalationDate;
    private Client client;
    private TypeDevice typeDevice;

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
