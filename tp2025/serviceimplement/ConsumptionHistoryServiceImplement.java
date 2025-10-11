package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.entities.ConsumptionHistory;
import pe.edu.upc.tp2025.repositories.IConsumptionHistoryRepository;
import pe.edu.upc.tp2025.serviceinterface.IConsumptionHistoryService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsumptionHistoryServiceImplement implements IConsumptionHistoryService {
    @Autowired
    private IConsumptionHistoryRepository  cHR;


    @Override
    public ConsumptionHistory insert(ConsumptionHistory consumptionHistory) {
        return cHR.save(consumptionHistory);
    }

    @Override
    public List<ConsumptionHistory> findByTypeOrderByDatetimeStarDesc(String type) {
        return cHR.findByTypeOrderByDatetimeStarDesc(type);
    }

    @Override
    public List<ConsumptionHistory> findByDatetimeStar(LocalDate datetimeStar) {
        return cHR.findByDatetimeStar(datetimeStar);
    }

    @Override
    public List<ConsumptionHistory> findByConsumption(String consumption) {
        return cHR.findByConsumption(consumption);
    }

    @Override
    public List<ConsumptionHistory> findByDatetimeStarBetween(LocalDate startDate, LocalDate endDate) {
        return cHR.findByDatetimeStarBetween(startDate, endDate);
    }
}







