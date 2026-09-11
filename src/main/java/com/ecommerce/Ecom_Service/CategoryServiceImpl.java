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
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryModel savedCategory = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (savedCategory != null) {
            throw new ApiException("Category with name " + categoryDTO.getCategoryName() + " already exists.");
        }

        CategoryModel category = modelMapper.map(categoryDTO, CategoryModel.class);
        CategoryModel saved = categoryRepository.save(category);
        return modelMapper.map(saved, CategoryDTO.class);
    }

    @Override
    public String deleteCategory(long categoryId) {
        CategoryModel categoryToDelete = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));

        categoryRepository.delete(categoryToDelete);
        return "Category with ID " + categoryId + " deleted successfully!";
    }

    @Override
    public String updateCategory(long categoryId, CategoryDTO categoryDTO) {
        CategoryModel existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));

        if (categoryDTO.getCategoryName() != null && !categoryDTO.getCategoryName().isBlank()) {
            existingCategory.setCategoryName(categoryDTO.getCategoryName());
        }

        categoryRepository.save(existingCategory);
        return "Category with ID " + categoryId + " updated successfully!";
    }
}
