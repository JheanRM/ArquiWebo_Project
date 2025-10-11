package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.RolDTO;
import pe.edu.upc.tp2025.entities.Rol;
import pe.edu.upc.tp2025.serviceimplement.RolServiceImplement;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolServiceImplement rSI;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<RolDTO> listar() {
        return rSI.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrar")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void registrar(@RequestBody RolDTO rol) {
        ModelMapper modelMapper = new ModelMapper();
        Rol ros = modelMapper.map(rol, Rol.class);
        rSI.insert(ros);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        rSI.deleteById(id);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void actualizar(@RequestBody RolDTO rol) {
        ModelMapper modelMapper = new ModelMapper();
        Rol r = modelMapper.map(rol, Rol.class);
        rSI.update(r);
    }


    @GetMapping("/tipoRol/{tipoRol}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<RolDTO> obtenerRolesPorTipoRol(@PathVariable String tipoRol) {
        return rSI.findRolesByTipoRol(tipoRol).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/usuario/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<RolDTO> obtenerRolesPorUsuario(@PathVariable int userId) {
        return rSI.findRolesByUserId(userId).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }
}
