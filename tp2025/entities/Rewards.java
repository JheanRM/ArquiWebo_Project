package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="recompensa")

public class Rewards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Titulo", nullable = false,length = 35)
    private String titulo;
    @Column(name = "Descipcion",nullable = false,length = 35)
    private String descipcion;
    @Column(name = "Category",nullable = false,length = 35)
    private String category;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;

    public Rewards() {
    }

    public Rewards(int id, String titulo, String descipcion, String category, Client client) {
        this.id = id;
        this.titulo = titulo;
        this.descipcion = descipcion;
        this.category = category;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
