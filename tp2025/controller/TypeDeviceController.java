package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.TypeDeviceDTO;
import pe.edu.upc.tp2025.entities.TypeDevice;
import pe.edu.upc.tp2025.serviceimplement.TypeDeviceServiceImplement;

@RestController
@RequestMapping("api/tipodevice")
public class TypeDeviceController {
    @Autowired
    private TypeDeviceServiceImplement tDSI;

    @PostMapping("/registrar")
    public void registrar(@RequestBody TypeDeviceDTO typeDeviceDTO) {
        ModelMapper modelMapper = new ModelMapper();
        TypeDevice td = modelMapper.map(typeDeviceDTO, TypeDevice.class);
        tDSI.insert(td);
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        try {
            TypeDevice typeDevice = tDSI.findByName(name);
            return ResponseEntity.ok(typeDevice);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping
    public void modificar(@RequestBody TypeDevice td) {
        tDSI.modificar(td);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        tDSI.eliminar(id);
    }
}
