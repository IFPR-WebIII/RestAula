package br.edu.ifpr.rest.services;

import br.edu.ifpr.rest.domain.Category;
import br.edu.ifpr.rest.repositories.CategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Integer id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("O id informado não existe");
        }
        return repository.findById(id).get();
    }

    public Category save(Category category){
       return repository.save(category);
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category update(Category category) {

        if (!repository.existsById(category.getId())){
            throw new NoSuchElementException("Id da categoria não encontrado");
        }

        return repository.save(category);
    }

    public void deleteById(Integer id) {
        if (!repository.existsById(id)){
            throw new NoSuchElementException("Id da categoria não encontrado");
        }

        repository.deleteById(id);
    }
}
