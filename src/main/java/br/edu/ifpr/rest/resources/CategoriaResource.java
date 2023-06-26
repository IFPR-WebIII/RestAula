package br.edu.ifpr.rest.resources;

import br.edu.ifpr.rest.domain.Category;
import br.edu.ifpr.rest.services.CategoryService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.UIResource;
import java.util.List;

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

        Category c1 = new Category(1, "Informática");
        service.save(c1);

        Category c2 = new Category(2, "Escritório");
        service.save(c2);

        List<Category> categories = service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        Category category = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping()
    public ResponseEntity<Category> create(@RequestBody  Category category){
        category = service.create(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category) {

        category.setId(id);
        category = service.update(category);

        return ResponseEntity.status(HttpStatus.OK).body(category);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }
}