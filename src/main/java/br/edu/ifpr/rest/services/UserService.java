package br.edu.ifpr.rest.services;

import br.edu.ifpr.rest.domain.entities.user.User;
import br.edu.ifpr.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findaAll(){
        return userRepository.findAll();
    }

    public User execute(User user) {

        User existsUser = userRepository.findByUsername(user.getUsername());

        if (existsUser != null) {
            throw new Error("User already exists!");
        }

        return userRepository.save(user);
    }

}
