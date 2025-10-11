package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.PaymentMethodDTO;
import pe.edu.upc.tp2025.dtos.PlanDTO;
import pe.edu.upc.tp2025.entities.PaymentMethod;
import pe.edu.upc.tp2025.entities.Plan;
import pe.edu.upc.tp2025.serviceimplement.PlanServiceImplement;

import java.util.List;

@RestController
@RequestMapping("api/plan")
public class PlanController {
    @Autowired
    private PlanServiceImplement pSI;

    @PostMapping("/registrar")
    public void registrar(@RequestBody PlanDTO planDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Plan pl = modelMapper.map(planDTO,Plan.class);
        pSI.insert(pl);
    }

    @GetMapping("/price-less-than/{price}")
    public List<Plan> findByPriceLessThan(@PathVariable("price") Double price) {
        return pSI.findByPriceLessThan(price);
    }

    @GetMapping("/duration/{duration}")
    public List<Plan> findByDuration(@PathVariable("duration") Integer duration) {
        return pSI.findByDuration(duration);
    }

    @PutMapping
    public void modificar(@RequestBody Plan p) {
        pSI.modificar(p); // actualización del plan
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pSI.eliminar(id); // elinar plan
    }
}
