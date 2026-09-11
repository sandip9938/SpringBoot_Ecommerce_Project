package com.ecommerce.Ecom_Service;

import com.ecommerce.Ecom_DTO.CategoryDTO;
import com.ecommerce.Ecom_DTO.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    String deleteCategory(long categoryId);
    String updateCategory(long categoryId, CategoryDTO categoryDTO);
}
