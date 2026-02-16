package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;
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

    @GetMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestParam(name="message",required = false) String message){
        //public ResponseEntity<String> echoMessage(@RequestParam(name="message", defaultValue = "hello World") String message){
        return new ResponseEntity<>("echoed Message: "+ message,HttpStatus.OK);
        // http://localhost:8080/api/echo?message="Hi"
    }

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //@GetMapping("/public/categories")
    @RequestMapping(value="/public/categories",method=RequestMethod.GET)
    private ResponseEntity<CategoryResponse>  getAllCategories(){
        CategoryResponse categoryResponse= categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestMapping(value="/public/categories",method=RequestMethod.POST)
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
       CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryID}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryID) {
            CategoryDTO deleteCategory= categoryService.deleteCategory(categoryID);
            return new ResponseEntity<>(deleteCategory, HttpStatus.OK);
    }

    //@PutMapping("/api/public/categories/{categoryID}")
    @RequestMapping(value="/public/categories/{categoryID}",method=RequestMethod.PUT)
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable Long categoryID){

            CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO,categoryID);
            return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);

    }
}
