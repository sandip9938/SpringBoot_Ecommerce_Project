package com.ecommerce.Ecom_Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.Ecom_Model.CategoryModel;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<CategoryModel> categories = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<CategoryModel> getAllCategories() {
        // Return the list of categories
        return categories;
    }

    @Override
    public void createCategory(CategoryModel category) {
        // Assign a unique ID to the new category and add it to the list
        category.setCategoryId(idCounter++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(long categoryId) {

        // Find the category by ID and remove it from the list
        CategoryModel categoryToDelete = categories.stream()
                .filter(category -> category.getCategoryId() == categoryId)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category with ID " + categoryId + " not found."));

        categories.remove(categoryToDelete);
        return "Category with ID " + categoryId + " deleted successfully!";
    }

    @Override
    public String updateCategory(long categoryId, CategoryModel category) {
        CategoryModel existingCategory = categories.stream()
                .filter(item -> item.getCategoryId() == categoryId)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category with ID " + categoryId + " not found."));

        if (category.getCategoryName() != null) {
            existingCategory.setCategoryName(category.getCategoryName());
        }

        return "Category with ID " + categoryId + " updated successfully!";
    }
}
