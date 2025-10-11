package pe.edu.upc.tp2025.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tp2025.entities.TypeDevice;

public class RangesDTO {
    private int id;
    private int maximum;
    private TypeDevice typedevice;

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
