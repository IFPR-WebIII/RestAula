package br.edu.ifpr.rest.repositories;

import br.edu.ifpr.rest.domain.entities.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String roleAdmin);
}