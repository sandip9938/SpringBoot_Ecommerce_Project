package com.ecommerce.Ecom_Service;

import java.util.List;

import com.ecommerce.Ecom_Model.CategoryModel;


public interface CategoryService {
    
    List<CategoryModel> getAllCategories();
    void createCategory(CategoryModel category);
    public String deleteCategory(long categoryId);
}
