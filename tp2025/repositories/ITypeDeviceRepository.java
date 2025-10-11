package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.entities.TypeDevice;

@Repository
public interface ITypeDeviceRepository extends JpaRepository<TypeDevice, Integer> {
    TypeDevice findByName(String name);
}
