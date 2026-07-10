package com.ecommerce.Ecom_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.Ecom_Model.CategoryModel;
import com.ecommerce.Ecom_Service.CategoryService;

@RestController

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Constructor to initialize the CategoryService
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Constructor to initialize sample categories
    @RequestMapping(value = "/api/public/categories", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    // Endpoint to create a new category
    @RequestMapping(value = "/api/public/categories", method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@RequestBody CategoryModel category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully!", HttpStatus.CREATED);
    }

    // Endpoint to delete a category by ID
    @RequestMapping(value = "/api/public/categories/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        try {
            String status = categoryService.deleteCategory(id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    // Update category endpoint
    @RequestMapping(value = "/api/public/categories/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCategories(@PathVariable long id, @RequestBody CategoryModel category) {
        try {
            String status = categoryService.updateCategory(id, category);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

}
