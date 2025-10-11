package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.ClienteConTarjetaVencidaDTO;
import pe.edu.upc.tp2025.dtos.PaymentMethodDTO;
import pe.edu.upc.tp2025.entities.PaymentMethod;
import pe.edu.upc.tp2025.serviceimplement.PaymentMethodServiceImplement;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodServiceImplement paymentMethodServiceImplement;

    @PostMapping("/registrar")
    public void registrar(@RequestBody PaymentMethodDTO paymentMethodDTO) {
        ModelMapper modelMapper = new ModelMapper();
        PaymentMethod pm = modelMapper.map(paymentMethodDTO, PaymentMethod.class);
        paymentMethodServiceImplement.insert(pm);
    }

    @GetMapping("/clientes-tarjetas-vencidas")
    public List<ClienteConTarjetaVencidaDTO> listarClientesConTarjetasVencidas() {
        return paymentMethodServiceImplement.getClientesConTarjetasVencidas();
    }

    @PutMapping
    public void modificar(@RequestBody PaymentMethod paymentMethod) {
        paymentMethodServiceImplement.modificar(paymentMethod);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        paymentMethodServiceImplement.eliminar(id);
    }
}
