package pe.edu.upc.tp2025.serviceinterface;

import pe.edu.upc.tp2025.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> list();
    public void insert (User u);
    public User listID(Long id);
    User update(User u);
    public void delete(Long id);
}
