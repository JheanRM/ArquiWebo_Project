package pe.edu.upc.tp2025.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.criteria.CriteriaBuilder;


public class ClienteConTarjetaVencidaDTO {
    private String nombreCliente;
    private Long numeroTarjeta;

    public ClienteConTarjetaVencidaDTO(String nombreCliente, Long numeroTarjeta) {
        this.nombreCliente = nombreCliente;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
