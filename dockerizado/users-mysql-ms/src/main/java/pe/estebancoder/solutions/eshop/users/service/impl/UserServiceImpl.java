package pe.estebancoder.solutions.eshop.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.eshop.users.model.User;
import pe.estebancoder.solutions.eshop.users.repository.UserRepository;
import pe.estebancoder.solutions.eshop.users.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            // Establece el ID del usuario actualizado con el ID proporcionado
            user.setId(id);
            // Guarda directamente el usuario actualizado en la base de datos
            return userRepository.save(user);
        }
        else{
            // Si no se encuentra el usuario, devolver null
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
