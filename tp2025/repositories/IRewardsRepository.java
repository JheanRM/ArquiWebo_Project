package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.entities.Rewards;

import java.util.List;

@Repository
public interface IRewardsRepository extends JpaRepository<Rewards, Integer> {
    List<Rewards> findByClientName(String clientName);

}
