package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.dtos.ClientesPorPlanDTO;
import pe.edu.upc.tp2025.entities.ClientPlan;

import java.util.List;

@Repository
public interface IClientPlanRepository extends JpaRepository<ClientPlan, Integer> {

    @Query("SELECT new pe.edu.upc.tp2025.dtos.ClientesPorPlanDTO(p.namePlan, COUNT(cp.client)) " +
            "FROM ClientPlan cp JOIN cp.plan p " +
            "GROUP BY p.namePlan")
    List<ClientesPorPlanDTO> contarClientesPorPlan();

}
