package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.entities.Ranges;
import pe.edu.upc.tp2025.repositories.IRangesRepository;
import pe.edu.upc.tp2025.serviceinterface.IRangesService;

import java.util.List;

@Service
public class RangesServiceImplement implements IRangesService {
    @Autowired
    private IRangesRepository rR;

    @Override
    public void insert(Ranges ranges) {
        rR.save(ranges);
    }

    @Override
    public List<String[]> OrdenRanges() {
        return rR.OrdenRanges();
    }

    @Override
    public void modificar(Ranges r) {
        if (rR.existsById(r.getId())) {
            rR.save(r);
        }
    }

    @Override
    public void eliminar(Integer id) {
        rR.deleteById(id);
    }

}
