package com.ecommerce.Ecom_Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ecommerce.Ecom_Model.CategoryModel;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    private List<CategoryModel> categories = new ArrayList<>();
    
    @Override
    public List<CategoryModel> getAllCategories() {
        return categories;
    }
    
    @Override
    public void createCategory(CategoryModel category) {
        categories.add(category);
    }
}
