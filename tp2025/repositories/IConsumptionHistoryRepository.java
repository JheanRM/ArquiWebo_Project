package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.tp2025.entities.ConsumptionHistory;

import java.time.LocalDate;
import java.util.List;

public interface IConsumptionHistoryRepository extends JpaRepository<ConsumptionHistory, Integer> {
    // Buscar por tipo exacto y ordenar por fecha de inicio descendente
    List<ConsumptionHistory> findByTypeOrderByDatetimeStarDesc(String type);

    // Buscar por fecha de inicio exacta
    List<ConsumptionHistory> findByDatetimeStar(LocalDate datetimeStar);

    // Buscar por consumo específico
    List<ConsumptionHistory> findByConsumption(String consumption);

    // Buscar por rango de fechas (inicio entre dos fechas)
    List<ConsumptionHistory> findByDatetimeStarBetween(LocalDate startDate, LocalDate endDate);

}
