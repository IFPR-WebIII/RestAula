package br.edu.ifpr.rest.resources;

import br.edu.ifpr.rest.domain.Category;
import br.edu.ifpr.rest.services.CategoryService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    CategoryService service;

    @Autowired
    public CategoriaResource(CategoryService service){
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Category>> findAll(){

        Category c1 = new Category(1, "Informática");
        service.save(c1);

        Category c2 = new Category(2, "Escritório");
        service.save(c2);

        List<Category> categories = service.findAll();

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping()
    public Category create(@RequestBody  Category category){
        return service.create(category);
    }
}
