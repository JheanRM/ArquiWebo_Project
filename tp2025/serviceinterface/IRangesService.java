package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.entities.Ranges;

import java.util.List;

public interface IRangesService {
    public void insert(Ranges ranges);

    List<String[]> OrdenRanges();

    public void modificar(Ranges r);

    public void eliminar(Integer id);

}
