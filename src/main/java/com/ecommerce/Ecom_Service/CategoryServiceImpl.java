package com.ecommerce.Ecom_Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.Ecom_Model.CategoryModel;
import com.ecommerce.Ecom_Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // private List<CategoryModel> categories = new ArrayList<>();

    @Override
    public List<CategoryModel> getAllCategories() {
        // Return the list of categories
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(CategoryModel category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {

        // Find the category by ID and remove it from the list
        CategoryModel categoryToDelete = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category with ID " + categoryId + " not found."));

        categoryRepository.delete(categoryToDelete);
        return "Category with ID " + categoryId + " deleted successfully!";
    }

    @Override
    public String updateCategory(long categoryId, CategoryModel category) {
        CategoryModel existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category with ID " + categoryId + " not found."));

        if (category.getCategoryName() != null) {
            existingCategory.setCategoryName(category.getCategoryName());
        }

        categoryRepository.save(existingCategory);
        return "Category with ID " + categoryId + " updated successfully!";
    }
}
