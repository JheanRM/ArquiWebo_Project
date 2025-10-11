package pe.edu.upc.tp2025.dtos;

import java.math.BigDecimal;

public class PromedioPuntosPorClienteDTO {
    private String nombreCliente;
    private String typeTransaction;
    private Double promedioPuntos;

    public PromedioPuntosPorClienteDTO() {
    }

    public PromedioPuntosPorClienteDTO(String nombreCliente, String typeTransaction, Double promedioPuntos) {
        this.nombreCliente = nombreCliente;
        this.typeTransaction = typeTransaction;
        this.promedioPuntos = promedioPuntos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Double getPromedioPuntos() {
        return promedioPuntos;
    }

    public void setPromedioPuntos(Double promedioPuntos) {
        this.promedioPuntos = promedioPuntos;
    }
}
