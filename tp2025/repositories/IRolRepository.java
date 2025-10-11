package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.tp2025.entities.Rol;

import java.util.List;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
    //Buscar rol por tipo de rol
    @Query("SELECT r FROM Rol r WHERE r.rol = :rol")
    List<Rol> findRolesByTipoRol(@Param("rol") String rol);

    //Buscar rol por el id del usuario
    @Query("SELECT r FROM Rol r WHERE r.user.userid = :userId")
    List<Rol> findRolesByUserId(@Param("userId") int userId);
}
