package com.ecommerce.Ecom_Model;

public class CategoryModel {
    private int categoryId;
    private String categoryName;

    // No-arg constructor
    public CategoryModel() {
    }

    // Constructor
    public CategoryModel(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
