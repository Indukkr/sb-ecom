package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void createCategory(Category Category);

    String deleteCategory(Long categoryID);

    Category updateCategory(Category category, Long categoryID);
}
