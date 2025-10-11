package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.dtos.ClientesPorPlanDTO;
import pe.edu.upc.tp2025.entities.ClientPlan;
import pe.edu.upc.tp2025.repositories.IClientPlanRepository;
import pe.edu.upc.tp2025.serviceinterface.IClientPlanService;

import java.util.List;

@Service
public class ClientPlanServiceImplement implements IClientPlanService {
    @Autowired
    private IClientPlanRepository cPR;


    @Override
    public ClientPlan insert(ClientPlan clientPlan) {
        return cPR.save(clientPlan);
    }

    @Override
    public List<ClientesPorPlanDTO> getClientesPorPlan() {
        return cPR.contarClientesPorPlan();
    }

    @Override
    public void delete(int id) {
        if (cPR.existsById(id)) {
            cPR.deleteById(id);
        } else {
            throw new RuntimeException("El ClientPlan con ID " + id + " no existe");
        }
    }
    @Override
    public ClientPlan update(ClientPlan clientPlan) {
        return cPR.save(clientPlan);
    }



}
