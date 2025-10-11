package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.dtos.PromedioPuntosPorClienteDTO;
import pe.edu.upc.tp2025.dtos.TotalPuntosClienteDTO;
import pe.edu.upc.tp2025.entities.Transactions;

import java.util.List;

public interface ITransaccionesService {
    public void insert(Transactions transactions);

    List<Object[]> findPromedioPuntosPorCliente();
    List<Object[]> calcularTotalPuntosPorCliente();
}
