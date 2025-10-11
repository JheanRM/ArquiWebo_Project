package pe.edu.upc.tp2025.dtos;

import java.time.LocalDate;

public class DispositivoPorFechaDTO {
    private String nombreDispositivo;
    private String tipoDispositivo;
    private Integer fechaInstalacion;

    public DispositivoPorFechaDTO(String nombreDispositivo, String tipoDispositivo, Integer fechaInstalacion) {
        this.nombreDispositivo = nombreDispositivo;
        this.tipoDispositivo = tipoDispositivo;
        this.fechaInstalacion = fechaInstalacion;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public Integer getFechaInstalacion() {
        return fechaInstalacion;
    }
}
