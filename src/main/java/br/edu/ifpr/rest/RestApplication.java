package br.edu.ifpr.rest;

import br.edu.ifpr.rest.domain.entities.Category;
import br.edu.ifpr.rest.domain.entities.user.Role;
import br.edu.ifpr.rest.domain.entities.user.User;
import br.edu.ifpr.rest.repositories.RoleRepository;
import br.edu.ifpr.rest.repositories.UserRepository;
import br.edu.ifpr.rest.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(UUID.randomUUID(), "Informática");
        categoryService.save(c1);

        Category c2 = new Category(UUID.randomUUID(), "Escritório");
        categoryService.save(c2);

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(admin);

        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setRole(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
}
