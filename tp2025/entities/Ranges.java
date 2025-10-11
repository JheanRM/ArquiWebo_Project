package pe.edu.upc.tp2025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ranges")
public class Ranges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "maximum", nullable = false,length = 35)
    private int maximum;
    @ManyToOne
    @JoinColumn(name = "typedevice_id")
    private TypeDevice typedevice;

    public Ranges() {
    }

    public Ranges(int id, int maximum, TypeDevice typedevice) {
        this.id = id;
        this.maximum = maximum;
        this.typedevice = typedevice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public TypeDevice getTypedevice() {
        return typedevice;
    }

    public void setTypedevice(TypeDevice typedevice) {
        this.typedevice = typedevice;
    }
}
