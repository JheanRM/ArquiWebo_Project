package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.entities.Ranges;

import java.util.List;

@Repository
public interface IRangesRepository extends JpaRepository<Ranges, Integer> {
    @Query(value = "SELECT d.name, r.maximum\n" +
            "FROM ranges r\n" +
            "JOIN device d ON r.typedevice_id = d.id\n" +
            "ORDER BY r.maximum DESC;",
            nativeQuery = true)
    List<String[]> OrdenRanges();
}
