package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.entities.TypeDevice;

public interface ITypeDeviceService {
    public void insert(TypeDevice typeDevice);
    TypeDevice findByName(String name);
    public void modificar(TypeDevice td);
    public void eliminar(Integer id);

}
