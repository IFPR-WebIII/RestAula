package br.edu.ifpr.rest.services;

import br.edu.ifpr.rest.domain.Category;
import br.edu.ifpr.rest.repositories.CategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Integer id){
        return repository.findById(id).orElseThrow();
    }

    public Category save(Category category){
       return repository.save(category);
    }

    public Category create(Category category) {
        return repository.save(category);
    }
}
