package com.ecommerce.Ecom_Service;


import com.ecommerce.Ecom_DTO.CategoryResponse;
import com.ecommerce.Ecom_Model.CategoryModel;


public interface CategoryService {
    
    CategoryResponse getAllCategories();
    void createCategory(CategoryModel category);
    public String deleteCategory(long categoryId);
    public String updateCategory(long categoryId, CategoryModel category);
}
