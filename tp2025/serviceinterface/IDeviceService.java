package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.dtos.DispositivoPorFechaDTO;
import pe.edu.upc.tp2025.entities.Device;

import java.util.List;

public interface IDeviceService {
    public void insert(Device device);

    List<DispositivoPorFechaDTO> getDispositivosPorRangoDeFechas(Integer fechaInicio, Integer fechaFin);

    public void eliminar(Integer id);

    public void modificar(Device device);
}
