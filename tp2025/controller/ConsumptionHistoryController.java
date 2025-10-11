package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.ConsumptionHistoryDTO;
import pe.edu.upc.tp2025.dtos.DeviceDTO;
import pe.edu.upc.tp2025.entities.ConsumptionHistory;
import pe.edu.upc.tp2025.entities.Device;
import pe.edu.upc.tp2025.serviceimplement.ConsumptionHistoryServiceImplement;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/ConsumptionHistory")
public class ConsumptionHistoryController {
    @Autowired
    private ConsumptionHistoryServiceImplement cHSI;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/registrar")
    public ConsumptionHistoryDTO insert(@RequestBody ConsumptionHistoryDTO consumptionHistoryDTO ) {
            ModelMapper modelMapper = new ModelMapper();
            ConsumptionHistory c= modelMapper.map(consumptionHistoryDTO, ConsumptionHistory.class);
            ConsumptionHistory saved=cHSI.insert(c);
            return modelMapper.map(saved, ConsumptionHistoryDTO.class);
    }

    @GetMapping("/by-type/{type}")
    public List<ConsumptionHistory> getByType(@PathVariable("type") String type) {
        return cHSI.findByTypeOrderByDatetimeStarDesc(type);
    }

    // Buscar por fecha exacta
    @GetMapping("/by-date/{date}")
    public List<ConsumptionHistory> getByDate(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return cHSI.findByDatetimeStar(date);
    }

    // Buscar por valor de consumo
    @GetMapping("/by-consumption/{consumption}")
    public List<ConsumptionHistory> getByConsumption(@PathVariable("consumption") String consumption) {
        return cHSI.findByConsumption(consumption);
    }

    // Buscar por rango de fechas
    @GetMapping("/by-date-range")
    public List<ConsumptionHistory> getByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return cHSI.findByDatetimeStarBetween(startDate, endDate);
    }

}
