package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.entities.Plan;

import java.util.List;

public interface IPlanService {
    public void insert(Plan plan);
    List<Plan> findByPriceLessThan(Double price);
    List<Plan> findByDuration(Integer duration);
    public void modificar(Plan plan);
    public void eliminar(Integer id); //



}
