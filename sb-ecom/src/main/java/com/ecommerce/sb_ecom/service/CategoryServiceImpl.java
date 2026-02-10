package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    //private List<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;

    //private Long nextID = 1L;

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryID(nextID++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryID) {

        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category not found with id: " + categoryID));

        categoryRepository.delete(category);

        return "Category with categoryID: " + categoryID + " deleted successfully";
    }


    @Override
    public Category updateCategory(Category category, Long categoryID) {

        Category savedCategory = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource Not Found"));

        category.setCategoryID(categoryID);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }


}
