package br.edu.ifpr.rest.resources;

import br.edu.ifpr.rest.domain.entities.Category;
import br.edu.ifpr.rest.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    CategoryService service;

    @Autowired
    public CategoriaResource(CategoryService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> findAll(){

        List<Category> categories = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable UUID id){
        Category category = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping()
    public ResponseEntity<Category> create(@Valid @RequestBody  Category category){
        category = service.create(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable UUID id, @RequestBody Category category) {

        category.setId(id);
        category = service.update(category);

        return ResponseEntity.status(HttpStatus.OK).body(category);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {

        service.deleteById(id);

    }
}