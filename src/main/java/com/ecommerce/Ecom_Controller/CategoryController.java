package com.ecommerce.Ecom_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping("/api/public/categories")
    public List<CategoryModel> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Endpoint to create a new category
    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody CategoryModel category) {
        categoryService.createCategory(category);
        return "Category created successfully!";
    }

    // Endpoint to delete a category by ID
    @DeleteMapping("/api/public/categories/{id}/delete")
    public String deleteCategory(@PathVariable long id) {
        return categoryService.deleteCategory(id);
    }

}
      

