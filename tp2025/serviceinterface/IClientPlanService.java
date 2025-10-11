package pe.edu.upc.tp2025.serviceinterface;


import pe.edu.upc.tp2025.dtos.ClientesPorPlanDTO;
import pe.edu.upc.tp2025.entities.ClientPlan;

import java.util.List;

public interface IClientPlanService {
    public ClientPlan insert(ClientPlan clientPlan);

    List<ClientesPorPlanDTO> getClientesPorPlan();

    void delete(int id);

    ClientPlan update(ClientPlan clientPlan);
}
