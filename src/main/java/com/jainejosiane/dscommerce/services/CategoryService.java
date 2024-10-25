package com.jainejosiane.dscommerce.services;

import com.jainejosiane.dscommerce.dto.CategoryDTO;
import com.jainejosiane.dscommerce.entities.Category;
import com.jainejosiane.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(CategoryDTO::new).toList();
    }
}