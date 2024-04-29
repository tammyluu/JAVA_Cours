package org.example.service;

import org.example.entity.User;
import org.example.port.IBaseRepository;

import java.util.List;

public class UserService {

    private final IBaseRepository userRepository;


    public UserService(IBaseRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(String userName, String email){
        if (userName.length() < 3 && userName.length() >30){
            throw  new RuntimeException("User Name length must be between 3 and 30 char");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email format invalided");
        }
        User user = new User(userName,email);

        // Enregistrer l'utilisateur dans le référentiel
        userRepository.create(user);

        return user;

    }
    private  boolean isValidEmail(String email){
        //le format valide est : <texte>@<domaine>.com
        return email.matches("^[\\w.-]+@[\\w.-]+\\.com$");
    }
    public List<User> serachUsers(String search){
        List<User> list = userRepository.findAll(search);
        return list;
    }

}
