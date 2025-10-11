package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.DeviceDTO;
import pe.edu.upc.tp2025.dtos.DispositivoPorFechaDTO;
import pe.edu.upc.tp2025.entities.Device;
import pe.edu.upc.tp2025.serviceimplement.DeviceServiceImplement;

import java.util.List;

@RestController
@RequestMapping("api/device")
public class DeviceController {
    @Autowired
    private DeviceServiceImplement dSI;

    @PostMapping("/registrar")
    public void registrar(@RequestBody DeviceDTO deviceDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Device dc = modelMapper.map(deviceDTO, Device.class);
        dSI.insert(dc);
    }

    @GetMapping("/por-fechas")
    public List<DispositivoPorFechaDTO> listarDispositivosPorRangoDeAnios(
            @RequestParam("inicio") Integer inicio,
            @RequestParam("fin") Integer fin) {
        return dSI.getDispositivosPorRangoDeFechas(inicio, fin);
    }

    @PutMapping
    public void modificar(@RequestBody Device device) {
        dSI.modificar(device);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        dSI.eliminar(id);
    }
}
