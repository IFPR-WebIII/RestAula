package br.edu.ifpr.rest.controllers;

import br.edu.ifpr.rest.domain.Category;
import br.edu.ifpr.rest.repositories.CategoryRepository;
import br.edu.ifpr.rest.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    CategoryService service;

    @Autowired
    public CategoriaController(CategoryService service){
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public List<Category> findAll(){

        Category c1 = new Category(1, "Informática");
        service.save(c1);

        Category c2 = new Category(2, "Escritório");
        service.save(c2);

        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){

        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

}
