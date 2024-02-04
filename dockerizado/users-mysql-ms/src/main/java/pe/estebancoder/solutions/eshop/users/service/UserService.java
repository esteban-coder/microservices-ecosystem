package pe.estebancoder.solutions.eshop.users.service;

import pe.estebancoder.solutions.eshop.users.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUserByUsername(String username);
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

}
