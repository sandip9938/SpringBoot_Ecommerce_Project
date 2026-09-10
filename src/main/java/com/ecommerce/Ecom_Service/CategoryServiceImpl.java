package com.ecommerce.Ecom_Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecom_DTO.CategoryDTO;
import com.ecommerce.Ecom_DTO.CategoryResponse;
import com.ecommerce.Ecom_Exception.ApiException;
import com.ecommerce.Ecom_Exception.ResourceNotFoundException;
import com.ecommerce.Ecom_Model.CategoryModel;
import com.ecommerce.Ecom_Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

   
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    // private List<CategoryModel> categories = new ArrayList<>();

    @Override
    public CategoryResponse getAllCategories() {
        List<CategoryModel> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new ApiException("No categories found.");
        }

        List<CategoryDTO> categoryDTOs = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOs);
        return categoryResponse;
    }

    @Override
    public void createCategory(CategoryModel category) {
        CategoryModel savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new ApiException("Category with name " + category.getCategoryName() + " already exists.");
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

        if (category.getCategoryName() != null && !category.getCategoryName().isBlank()) {
            existingCategory.setCategoryName(category.getCategoryName());
        }

        categoryRepository.save(existingCategory);
        return "Category with ID " + categoryId + " updated successfully!";
    }
}
