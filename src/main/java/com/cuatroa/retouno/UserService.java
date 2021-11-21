/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.retouno;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author david
 */

/**
 * Esta clase es el servicio de Reservation
 * Revisar este drive tiene el front y el back https://drive.google.com/drive/folders/1YvH1DRKhxE6g0bAHcwfrfODXxu8nBXdx?usp=sharing
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    
    /**
     * Este sirve para registrar
     * @param reservation
     * @return
     */
    
    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * Este realiza la verificacion de la existencia del correo
     * @return
     */
    
    
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    
      /**
     * Este realiza la verificacion de la existencia del correo
     * @return
     */
    
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
