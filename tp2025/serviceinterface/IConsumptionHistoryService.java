package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.entities.ConsumptionHistory;

import java.time.LocalDate;
import java.util.List;

public interface IConsumptionHistoryService {
    public ConsumptionHistory insert(ConsumptionHistory consumptionHistory);
    List<ConsumptionHistory> findByTypeOrderByDatetimeStarDesc(String type);
    List<ConsumptionHistory> findByDatetimeStar(LocalDate datetimeStar);
    List<ConsumptionHistory> findByConsumption(String consumption);
    List<ConsumptionHistory> findByDatetimeStarBetween(LocalDate startDate, LocalDate endDate);
}

