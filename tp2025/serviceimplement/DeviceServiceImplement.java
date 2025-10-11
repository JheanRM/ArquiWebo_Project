package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.dtos.DispositivoPorFechaDTO;
import pe.edu.upc.tp2025.entities.Device;
import pe.edu.upc.tp2025.repositories.IDeviceRepository;
import pe.edu.upc.tp2025.serviceinterface.IDeviceService;

import java.util.List;

@Service
public class DeviceServiceImplement implements IDeviceService {
    @Autowired
    private IDeviceRepository dR;

    @Override
    public void insert(Device device) {
        dR.save(device);
    }

    @Override
    public List<DispositivoPorFechaDTO> getDispositivosPorRangoDeFechas(Integer fechaInicio, Integer fechaFin) {
        return dR.findDispositivosPorRangoDeFechas(fechaInicio, fechaFin);
    }

    @Override
    public void eliminar(Integer id) {
        dR.deleteById(id);
    }

    @Override
    public void modificar(Device device) {
        dR.save(device);
    }

}
