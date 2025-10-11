package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.dtos.RewardsByClientDTO;
import pe.edu.upc.tp2025.entities.Rewards;
import pe.edu.upc.tp2025.repositories.IRewardsRepository;
import pe.edu.upc.tp2025.serviceinterface.IRewardsService;

import java.util.List;

@Service
public class RewardsServiceImplement implements IRewardsService {
   @Autowired
   private IRewardsRepository rR;

    @Override
    public Rewards insert(Rewards rewards) {
       return rR.save(rewards);
    }

    @Override
    public List<RewardsByClientDTO> findByClientName(String clientName) {
        List<Rewards> rewards = rR.findByClientName(clientName);
        return rewards.stream()
                .map(r -> new RewardsByClientDTO(r.getClient().getName(), r.getDescipcion()))
                .toList();
    }

    @Override
    public void modificar(Rewards r) {
        if (rR.existsById(r.getId())) {
            rR.save(r);
        }
    }

    @Override
    public void eliminar(Integer id) {
        rR.deleteById(id);
    }
}
