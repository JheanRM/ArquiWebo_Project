package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.dtos.ClienteConTarjetaVencidaDTO;
import pe.edu.upc.tp2025.entities.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {
    public void insert(PaymentMethod paymentMethod);

    List<ClienteConTarjetaVencidaDTO> getClientesConTarjetasVencidas();

    public void eliminar(Long id);
    public void modificar(PaymentMethod paymentMethod);
}
