package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.PromedioPuntosPorClienteDTO;
import pe.edu.upc.tp2025.dtos.TotalPuntosClienteDTO;
import pe.edu.upc.tp2025.dtos.TransactionsDTO;
import pe.edu.upc.tp2025.entities.Transactions;
import pe.edu.upc.tp2025.serviceimplement.TransactionsServiceImplement;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Transacciones")
public class TransactionsController {
    @Autowired
    private TransactionsServiceImplement tSI;

    @PostMapping("/registrar")
    public void registrar(@RequestBody TransactionsDTO transactionsDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Transactions ts = modelMapper.map(transactionsDTO, Transactions.class);
        tSI.insert(ts);
    }

    @GetMapping("/promedio-puntos")
    public List<Object[]> promedioPuntos() {
        return tSI.findPromedioPuntosPorCliente();
    }

    @GetMapping("/total-puntos")
    public List<Object[]> totalPuntos() {
        return tSI.calcularTotalPuntosPorCliente();
    }

}
