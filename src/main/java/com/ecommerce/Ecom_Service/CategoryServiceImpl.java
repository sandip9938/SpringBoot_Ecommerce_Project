package com.ecommerce.Ecom_Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.Ecom_DTO.CategoryResponse;
import com.ecommerce.Ecom_Exception.ResourceNotFoundException;
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
    public CategoryResponse getAllCategories() {
        // Return the list of categories
        if (categoryRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("No categories found.");
        }
        return new CategoryResponse(categoryRepository.findAll());
    }

    @Override
    public void createCategory(CategoryModel category) {
        CategoryModel savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new ResourceNotFoundException("Category with name " + category.getCategoryName() + " already exists.");
        }   
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {

        // Find the category by ID and remove it from the list
        CategoryModel categoryToDelete = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category", "ID", categoryId));

        categoryRepository.delete(categoryToDelete);
        return "Category with ID " + categoryId + " deleted successfully!";
    }

    @Override
    public String updateCategory(long categoryId, CategoryModel category) {
        CategoryModel existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category", "ID", categoryId));

        if (category.getCategoryName() != null) {
            existingCategory.setCategoryName(category.getCategoryName());
        }

        categoryRepository.save(existingCategory);
        return "Category with ID " + categoryId + " updated successfully!";
    }
}
