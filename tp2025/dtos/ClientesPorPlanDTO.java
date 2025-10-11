package pe.edu.upc.tp2025.dtos;

public class ClientesPorPlanDTO {
    private String nombrePlan;
    private Long cantidadClientes;

    public ClientesPorPlanDTO(String nombrePlan, Long cantidadClientes) {
        this.nombrePlan = nombrePlan;
        this.cantidadClientes = cantidadClientes;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public Long getCantidadClientes() {
        return cantidadClientes;
    }
}
