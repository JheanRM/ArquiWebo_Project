package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.dtos.ClienteConTarjetaVencidaDTO;
import pe.edu.upc.tp2025.entities.PaymentMethod;
import pe.edu.upc.tp2025.repositories.IPaymentMethodRepository;
import pe.edu.upc.tp2025.serviceinterface.IPaymentMethodService;

import java.util.List;

@Service
public class PaymentMethodServiceImplement implements IPaymentMethodService {
    @Autowired
    private IPaymentMethodRepository pMR;

    @Override
    public void insert(PaymentMethod paymentMethod) {
        pMR.save(paymentMethod);
    }

    @Override
    public List<ClienteConTarjetaVencidaDTO> getClientesConTarjetasVencidas() {
        return pMR.findClientesConTarjetasVencidas();
    }


    @Override
    public void eliminar(Long id) {
        pMR.deleteById(id);
    }

    @Override
    public void modificar(PaymentMethod paymentMethod) {
        pMR.save(paymentMethod);
    }



}
