package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.ClientPlanDTO;
import pe.edu.upc.tp2025.dtos.ClientesPorPlanDTO;
import pe.edu.upc.tp2025.entities.ClientPlan;
import pe.edu.upc.tp2025.serviceimplement.ClientPlanServiceImplement;

import java.util.List;

@RestController
@RequestMapping("api/clienteplan")
public class ClientPlanController {
    @Autowired
    private ClientPlanServiceImplement cPSI;

    @PostMapping("/registrar")
    public ClientPlanDTO insert(@RequestBody ClientPlanDTO clientPlanDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ClientPlan c = modelMapper.map(clientPlanDTO, ClientPlan.class);
        ClientPlan saved= cPSI.insert(c);
        return modelMapper.map(saved, ClientPlanDTO.class);
    }

    @GetMapping("/clientes-por-plan")
    public List<ClientesPorPlanDTO> listarClientesPorPlan() {
        return cPSI.getClientesPorPlan();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        cPSI.delete(id);
    }

    @PutMapping("/{id}")
    public ClientPlan update(@PathVariable("id") int id, @RequestBody ClientPlan clientPlan) {
        clientPlan.setId(id);
        return cPSI.update(clientPlan);
    }
}
