package pe.edu.upc.tp2025.dtos;

public class ClienteConPuntosDTO {
    private String nombreCliente;
    private Long totalPuntos;

    public ClienteConPuntosDTO(String nombreCliente, Long totalPuntos) {
        this.nombreCliente = nombreCliente;
        this.totalPuntos = totalPuntos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Long getTotalPuntos() {
        return totalPuntos;
    }
}
