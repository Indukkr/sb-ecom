package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    public CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //@GetMapping("/public/categories")
    @RequestMapping(value="/public/categories",method=RequestMethod.GET)
    private ResponseEntity<List<Category>>  getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestMapping(value="/public/categories",method=RequestMethod.POST)
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category Added Succesfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryID}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryID) {
            String status = categoryService.deleteCategory(categoryID);
            return new ResponseEntity<>(status, HttpStatus.OK);
    }

    //@PutMapping("/api/public/categories/{categoryID}")
    @RequestMapping(value="/public/categories/{categoryID}",method=RequestMethod.PUT)
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category,
                                                 @PathVariable Long categoryID){

            Category savedCategory = categoryService.updateCategory(category,categoryID);
            return new ResponseEntity<>("categoryID: "+categoryID+" is updated successfully !!", HttpStatus.OK);

    }
}
