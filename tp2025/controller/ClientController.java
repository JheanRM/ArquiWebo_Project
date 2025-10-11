package pe.edu.upc.tp2025.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp2025.dtos.ClientDTO;
import pe.edu.upc.tp2025.dtos.ClientDeviceCountDTO;
import pe.edu.upc.tp2025.dtos.ClienteConPuntosDTO;
import pe.edu.upc.tp2025.entities.Client;
import pe.edu.upc.tp2025.serviceimplement.ClientServiceImplement;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClientController {
    @Autowired
    private ClientServiceImplement cSI;

    @PostMapping("/registrar")
    public void registrar(@RequestBody ClientDTO clientDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Client cl = modelMapper.map(clientDTO, Client.class);
        cSI.insert(cl);
    }

    @GetMapping("/client-device-count")
    public List<ClientDeviceCountDTO> getClientDeviceCount() {
        List<Object[]> results = cSI.clientsDeviceCount();
        List<ClientDeviceCountDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            ClientDeviceCountDTO dto = new ClientDeviceCountDTO();
            dto.setClientName((String) result[0]); // c.name
            dto.setDeviceCount((Long) result[1]); // COUNT(d)
            dto.setInstalationDate((Integer) result[2]); // MAX(d.installationDate)
            dtos.add(dto);
        }

        return dtos;
    }


    @GetMapping("/mas-puntos")
    public List<ClienteConPuntosDTO> obtenerClientesConMasDeXPuntos(
            @RequestParam("minPuntos") Long minPuntos) {
        return cSI.obtenerClientesConMasDeXPuntos(minPuntos);
    }


    @GetMapping("/by-name/{name}")
    public List<Client> getByName(@PathVariable("name") String name) {
        return cSI.findByName(name);
    }

    // Buscar por correo
    @GetMapping("/by-email/{email}")
    public List<Client> getByEmail(@PathVariable("email") String email) {
        return cSI.findByEmail(email);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable("id") int id, @RequestBody Client client) {
        client.setId(id); // aseguramos usar el id de la URL
        return cSI.update(client);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cSI.eliminar(id); // 👈 elimina el cliente por ID
    }
}
