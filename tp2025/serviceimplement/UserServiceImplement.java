package pe.edu.upc.tp2025.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp2025.entities.User;
import pe.edu.upc.tp2025.repositories.IUsersRepository;
import pe.edu.upc.tp2025.serviceinterface.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUsersRepository uR;

    @Override
    public List<User> list() {
        return uR.findAll();
    }


    @Override
    public void insert(User u) {
        uR.save(u);
    }


    @Override
    public User listID(Long id) {
        return uR.findById(id).orElse(new User());
    }

    public User update(User u) {
        return uR.save(u);
    }

    @Override
    public void delete(Long id) {
        uR.deleteById(id);
    }
}
