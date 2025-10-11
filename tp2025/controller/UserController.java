package pe.edu.upc.tp2025.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.TransactionsDTO;
import pe.edu.upc.tp2025.dtos.UserDTO;
import pe.edu.upc.tp2025.entities.ClientPlan;
import pe.edu.upc.tp2025.entities.Rol;
import pe.edu.upc.tp2025.entities.Transactions;
import pe.edu.upc.tp2025.entities.User;
import pe.edu.upc.tp2025.serviceimplement.UserServiceImplement;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceImplement uSI;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER')")
    public List<UserDTO> listar() {
        return uSI.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void registrar(@RequestBody UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User us= modelMapper.map(userDTO, User.class);
        uSI.insert(us);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER')")
    public UserDTO buscarID(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto=m.map(uSI.listID(id),UserDTO.class);
        return dto;
    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id) {
        uSI.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user) {
        User existingUser = uSI.listID(id);
        if (existingUser == null || existingUser.getUserid() == null) {
            return ResponseEntity.notFound().build();
        }

        user.setUserid(id);
        User updated = uSI.update(user);
        return ResponseEntity.ok(updated);
    }



}
