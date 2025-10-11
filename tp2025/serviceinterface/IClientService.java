package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.dtos.ClienteConPuntosDTO;
import pe.edu.upc.tp2025.dtos.TotalPuntosClienteDTO;
import pe.edu.upc.tp2025.entities.Client;

import java.util.List;

public interface IClientService {
    public void insert(Client client);

    List<Object[]> clientsDeviceCount();

    List<ClienteConPuntosDTO> obtenerClientesConMasDeXPuntos(Long minPuntos);

    List<Client> findByName(String name);

    List<Client> findByEmail(String email);

    Client update(Client client);

    public void eliminar(Integer id);
}
