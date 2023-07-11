package br.edu.ifpr.rest.services;

import br.edu.ifpr.rest.domain.entities.user.Role;
import br.edu.ifpr.rest.domain.entities.user.User;
import br.edu.ifpr.rest.repositories.RoleRepository;
import br.edu.ifpr.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User createRole(User user) {

        List<Role> roles;

        if (userRepository.findById(user.getId()).isEmpty()) {
            throw new Error("User does not exists!");
        }

        roles = user.getRoles();

        user.setRoles(roles);

        userRepository.save(user);

        return user;

    }

    public Role getRoleByName(String roleName){
        if (roleRepository.findByName(roleName) == null){
            throw new IllegalArgumentException("Role not exists");
        }

        return roleRepository.findByName(roleName);
    }

}
