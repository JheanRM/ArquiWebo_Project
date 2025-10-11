package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.entities.TypeDevice;
import pe.edu.upc.tp2025.repositories.ITypeDeviceRepository;
import pe.edu.upc.tp2025.serviceinterface.ITypeDeviceService;

@Service
public class TypeDeviceServiceImplement implements ITypeDeviceService {

    @Autowired
    private ITypeDeviceRepository tDR;

    @Override
    public void insert(TypeDevice typeDevice) {
        tDR.save(typeDevice);
    }

    @Override
    public TypeDevice findByName(String name) {
        TypeDevice device = tDR.findByName(name);
        if (device == null) {
            throw new RuntimeException("No se encontró un dispositivo con el nombre: " + name);
        }
        return device;
    }

    @Override
    public void modificar(TypeDevice td) {
        if (tDR.existsById(td.getId())) {
            tDR.save(td);
        }
    }

    @Override
    public void eliminar(Integer id) {
        tDR.deleteById(id);
    }
}
