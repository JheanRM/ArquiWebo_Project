package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.RewardsByClientDTO;
import pe.edu.upc.tp2025.dtos.RewardsDTO;
import pe.edu.upc.tp2025.entities.Rewards;
import pe.edu.upc.tp2025.serviceimplement.RewardsServiceImplement;

import java.util.List;

@RestController
@RequestMapping("api/Recompensa")
public class RewardsController {

    @Autowired
    private RewardsServiceImplement rSI;

    @PostMapping("/Registrar")
    public RewardsDTO registrar(@RequestBody RewardsDTO rewardsDTO) {
        ModelMapper  modelMapper = new ModelMapper();
        Rewards r= modelMapper.map(rewardsDTO, Rewards.class);
        Rewards saved=rSI.insert(r);
        return modelMapper.map(saved, RewardsDTO.class);
    }

    @GetMapping("/find-client/{name}")
    public List<RewardsByClientDTO> getRewardsByClient(@PathVariable("name") String name) {
        return rSI.findByClientName(name);
    }

    @PutMapping
    public void modificar(@RequestBody Rewards r) {
        rSI.modificar(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rSI.eliminar(id);
    }
}
