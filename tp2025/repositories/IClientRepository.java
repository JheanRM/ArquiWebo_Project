package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.dtos.TotalPuntosClienteDTO;
import pe.edu.upc.tp2025.entities.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c.name, COUNT(d), d.instalationDate " +
            "FROM Client c " +
            "LEFT JOIN Device d ON d.client = c " +
            "GROUP BY c.id, c.name, d.instalationDate " +
            "ORDER BY d.instalationDate DESC NULLS LAST")
    List<Object[]> clientsDeviceCount();


    @Query(value = "SELECT c.Name AS nombreCliente, SUM(t.Points) AS totalPuntos " +
            "FROM client c " +
            "JOIN transacciones t ON c.id = t.cliente_id " +
            "GROUP BY c.Name " +
            "HAVING SUM(t.Points) > :minPuntos",
            nativeQuery = true)
    List<Object[]> findClientesConMasDeXPuntos( Long minPuntos);

    // Buscar clientes por nombre
    List<Client> findByName(String name);

    // Buscar clientes por email
    List<Client> findByEmail(String email);

}
