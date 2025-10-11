package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp2025.dtos.ClienteConTarjetaVencidaDTO;
import pe.edu.upc.tp2025.entities.PaymentMethod;

import java.util.List;

@Repository
public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query("SELECT new pe.edu.upc.tp2025.dtos.ClienteConTarjetaVencidaDTO(c.name, pm.numberCard) " +
            "FROM PaymentMethod pm JOIN pm.client c " +
            "WHERE pm.expiration < CURRENT_DATE")
    List<ClienteConTarjetaVencidaDTO> findClientesConTarjetasVencidas();
}
