package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.entities.Plan;
import pe.edu.upc.tp2025.repositories.IPlanRepository;
import pe.edu.upc.tp2025.serviceinterface.IPlanService;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImplement implements IPlanService {
    @Autowired
    private IPlanRepository pR;

    @Override
    public void insert(Plan plan) {
        pR.save(plan);
    }

    @Override
    public List<Plan> findByPriceLessThan(Double price) {
        return pR.findByPriceLessThan(price);
    }

    @Override
    public List<Plan> findByDuration(Integer duration) {
        return pR.findByDuration(duration);
    }

    @Override
    public void modificar(Plan plan) {
        Optional<Plan> optionalPlan = pR.findById(plan.getIdPlan());
        if (optionalPlan.isPresent()) {
            Plan existingPlan = optionalPlan.get();
            existingPlan.setNamePlan(plan.getNamePlan());
            existingPlan.setPrice(plan.getPrice());
            existingPlan.setDuration(plan.getDuration());
            existingPlan.setCharacteristics(plan.getCharacteristics());
            existingPlan.setMaxDevice(plan.getMaxDevice());
            pR.save(existingPlan);
        }
    }

    @Override
    public void eliminar(Integer id) {
        pR.deleteById(id); //
    }
}
