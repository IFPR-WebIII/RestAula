package br.edu.ifpr.rest.resources;

import br.edu.ifpr.rest.domain.entities.RegisterDTO;
import br.edu.ifpr.rest.domain.entities.user.AutheticationDTO;
import br.edu.ifpr.rest.domain.entities.user.User;
import br.edu.ifpr.rest.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authentication;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutheticationDTO auth){

        var login = new UsernamePasswordAuthenticationToken(auth.login(), auth.password());
        Authentication authenticate = authentication.authenticate(login);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO register){

        if (this.userRepository.findByUsername(register.username()) != null) return ResponseEntity.badRequest().build();

        String password = new BCryptPasswordEncoder().encode(register.password());
        User user = new User(register.name(), register.username(), password, register.role());

        user = userRepository.save(user);

        return ResponseEntity.ok().body(user);

    }

}
