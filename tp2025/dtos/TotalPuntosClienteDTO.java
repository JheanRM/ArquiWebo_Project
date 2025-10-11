package pe.edu.upc.tp2025.dtos;

public class TotalPuntosClienteDTO {
    private String nombreCliente;
    private Double totalPuntos;

    public TotalPuntosClienteDTO(String nombreCliente, Double totalPuntos) {
        this.nombreCliente = nombreCliente;
        this.totalPuntos = totalPuntos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Double getTotalPuntos() {
        return totalPuntos;
    }
}
