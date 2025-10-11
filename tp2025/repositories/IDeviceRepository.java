package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.dtos.DispositivoPorFechaDTO;
import pe.edu.upc.tp2025.entities.Device;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDeviceRepository extends JpaRepository<Device, Integer> {

    @Query("SELECT new pe.edu.upc.tp2025.dtos.DispositivoPorFechaDTO(d.name, td.name, d.instalationDate) " +
            "FROM Device d JOIN d.typeDevice td " +
            "WHERE d.instalationDate BETWEEN :fechaInicio AND :fechaFin")
    List<DispositivoPorFechaDTO> findDispositivosPorRangoDeFechas(Integer fechaInicio, Integer fechaFin);
}
