package br.edu.ifpr.rest.domain.entities;

import br.edu.ifpr.rest.domain.entities.user.Role;

public record RegisterDTO(String name, String username, String password, Role role)  {
}
