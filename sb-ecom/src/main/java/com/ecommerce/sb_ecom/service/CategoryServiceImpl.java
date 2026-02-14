package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.exception.APIException;
import com.ecommerce.sb_ecom.exception.ResourceNotFoundException;
import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("No category present in database");
        }
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory!=null)
            throw new APIException("Category with name "+ category.getCategoryName()+"already Exists");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryID) {

        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResourceNotFoundException("Category","CategoryID", categoryID));

        categoryRepository.delete(category);

        return "Category with categoryID: " + categoryID + " deleted successfully";
    }


    @Override
    public Category updateCategory(Category category, Long categoryID) {

        Category savedCategory = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResourceNotFoundException("Category","CategoryID", categoryID)) ;
        category.setCategoryID(categoryID);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }


}
