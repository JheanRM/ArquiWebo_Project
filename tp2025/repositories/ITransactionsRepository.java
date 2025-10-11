package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.dtos.PromedioPuntosPorClienteDTO;
import pe.edu.upc.tp2025.dtos.TotalPuntosClienteDTO;
import pe.edu.upc.tp2025.entities.Transactions;

import java.util.List;

@Repository
public interface    ITransactionsRepository extends JpaRepository<Transactions,Integer> {
    @Query(value = "SELECT c.name AS nombreCliente, t.type_transactions AS tipoTransaccion, AVG(t.points) AS promedioPuntos " +
            "FROM client c " +
            "JOIN transacciones t ON c.id = t.cliente_id " +
            "GROUP BY c.name, t.type_transactions " +
            "ORDER BY AVG(t.points) DESC",
            nativeQuery = true)
    List<Object[]> findPromedioPuntosPorCliente();






    @Query(value = "SELECT c.Name AS nombreCliente, SUM(t.Points) AS totalPuntos " +
            "FROM client c " +
            "JOIN transacciones t ON c.id = t.cliente_id " +
            "GROUP BY c.Name",
            nativeQuery = true)
    List<Object[]> calcularTotalPuntosPorCliente();
}
