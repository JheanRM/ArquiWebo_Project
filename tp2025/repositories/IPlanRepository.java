package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.entities.Plan;

import java.util.List;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Integer> {
    List<Plan> findByPriceLessThan(Double price);
    List<Plan> findByDuration(Integer duration);

}
