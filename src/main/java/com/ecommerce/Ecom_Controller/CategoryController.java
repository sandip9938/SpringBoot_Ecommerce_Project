package com.ecommerce.Ecom_Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.Ecom_Model.CategoryModel;

@RestController
public class CategoryController {
    // Sample data for demonstration purposes
    private List<CategoryModel> categories = new ArrayList<>();

    // Constructor to initialize sample categories
    @GetMapping("/api/public/categories")
    public List<CategoryModel> getAllCategories() {
        return categories;
    }

    // Endpoint to create a new category
    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody CategoryModel category) {
        categories.add(category);
        return "Category created successfully!";
    }


}
