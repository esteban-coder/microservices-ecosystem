package pe.estebancoder.solutions.eshop.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.eshop.users.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
