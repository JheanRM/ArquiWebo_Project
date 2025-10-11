package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.DeviceMaximunDTO;
import pe.edu.upc.tp2025.dtos.RangesDTO;
import pe.edu.upc.tp2025.entities.Ranges;
import pe.edu.upc.tp2025.entities.Rewards;
import pe.edu.upc.tp2025.serviceimplement.RangesServiceImplement;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Ranges")
public class RangesController {

    @Autowired
    private RangesServiceImplement rSI;

    @PostMapping("/registrar")
    public void registrar(@RequestBody RangesDTO rangesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Ranges rag = modelMapper.map(rangesDTO, Ranges.class);
        rSI.insert(rag);
    }


    @GetMapping("/listar")
    public List<DeviceMaximunDTO> listar(){
        List<String[]> ls = rSI.OrdenRanges();
        List<DeviceMaximunDTO> lista = new ArrayList<>();
        for(String[] columna : ls){
            DeviceMaximunDTO dto = new DeviceMaximunDTO();
            dto.setName(columna[0]); // name está en la posición 0
            dto.setMaximum(Integer.parseInt(columna[1])); // maximum está en la posición 1
            lista.add(dto);
        }
        return lista;
    }

    @PutMapping
    public void modificar(@RequestBody Ranges r) {
        rSI.modificar(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rSI.eliminar(id);
    }


}
