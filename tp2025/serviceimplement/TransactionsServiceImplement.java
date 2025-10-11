package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.dtos.PromedioPuntosPorClienteDTO;
import pe.edu.upc.tp2025.dtos.TotalPuntosClienteDTO;
import pe.edu.upc.tp2025.entities.Transactions;
import pe.edu.upc.tp2025.repositories.ITransactionsRepository;
import pe.edu.upc.tp2025.serviceinterface.ITransaccionesService;

import java.util.List;

@Service
public class TransactionsServiceImplement implements ITransaccionesService {

    @Autowired
    private ITransactionsRepository tR;

    @Override
    public void insert(Transactions transactions) {
        tR.save(transactions);
    }

    @Override
    public List<Object[]> findPromedioPuntosPorCliente() {
        return tR.findPromedioPuntosPorCliente();
    }

    @Override
    public List<Object[]> calcularTotalPuntosPorCliente() {
        return tR.calcularTotalPuntosPorCliente();
    }


}
