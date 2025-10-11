package pe.edu.upc.tp2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.tp2025.entities.User;

public interface IUsersRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

}
