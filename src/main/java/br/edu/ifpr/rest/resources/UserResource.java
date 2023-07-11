package br.edu.ifpr.rest.resources;

import br.edu.ifpr.rest.domain.entities.user.User;
import br.edu.ifpr.rest.services.RoleService;
import br.edu.ifpr.rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping()
    public List<User> findAll() {
        return userService.findaAll();
    }

    @PostMapping()
    public User create(@RequestBody User user) {
        return userService.execute(user);
    }

    @PostMapping("/role")
    public User role(@RequestBody User user) {

        return roleService.createRole(user);

    }

}
