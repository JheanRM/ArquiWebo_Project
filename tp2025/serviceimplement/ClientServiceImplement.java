package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.dtos.ClienteConPuntosDTO;
import pe.edu.upc.tp2025.dtos.TotalPuntosClienteDTO;
import pe.edu.upc.tp2025.entities.Client;
import pe.edu.upc.tp2025.repositories.IClientRepository;
import pe.edu.upc.tp2025.serviceinterface.IClientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImplement implements IClientService {
    @Autowired
    private IClientRepository cR;
    @Override
    public void insert(Client client) {
        cR.save(client);
    }

    @Override
    public List<Object[]> clientsDeviceCount() {
        return cR.clientsDeviceCount();
    }

    @Override
    public List<ClienteConPuntosDTO> obtenerClientesConMasDeXPuntos(Long minPuntos) {
        List<Object[]> results = cR.findClientesConMasDeXPuntos(minPuntos);
        return results.stream()
                .map(row -> new ClienteConPuntosDTO(
                        (String) row[0],
                        ((Number) row[1]).longValue()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByName(String name) {
        return cR.findByName(name);
    }

    @Override
    public List<Client> findByEmail(String email) {
        return cR.findByEmail(email);
    }

    @Override
    public Client update(Client client) {
        return cR.save(client);
    }

    @Override
    public void eliminar(Integer id) {
        cR.deleteById(id); // 👈 aquí se elimina el cliente por ID
    }


}
