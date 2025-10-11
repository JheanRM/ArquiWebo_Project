package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.dtos.RewardsByClientDTO;
import pe.edu.upc.tp2025.entities.Rewards;

import java.util.List;

public interface IRewardsService {
    public Rewards insert(Rewards rewards);
    List<RewardsByClientDTO> findByClientName(String clientName);
    public void modificar(Rewards r);
    public void eliminar(Integer id);

}
