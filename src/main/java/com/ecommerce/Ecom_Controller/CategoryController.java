package com.ecommerce.Ecom_Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecom_DTO.CategoryDTO;
import com.ecommerce.Ecom_DTO.CategoryResponse;
import com.ecommerce.Ecom_Service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/api/public/categories", method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/public/categories", method = RequestMethod.POST)
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/public/categories/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        String status = categoryService.deleteCategory(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/public/categories/{id}/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCategories(@PathVariable long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        String status = categoryService.updateCategory(id, categoryDTO);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}