package br.edu.ifpr.rest.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull(message = "O nome da categoria não pode ser nulo")
    @NotBlank(message = "O nome da categoria não pode ser vazio")
    @Length(min = 3, max = 60, message = "O nome da categoria deve possuir entre 3 e 60")
    @Column(nullable = false)
    private String name;

    public Category(){}

    public Category(String name) {
        this.name = name;
    }

    public Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
