package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipodevice")
public class TypeDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name",nullable = false,length = 35)
    private String name;

    public TypeDevice() {
    }

    public TypeDevice(int id, String name) {
        this.id = id;
        this.name = name;
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
}
