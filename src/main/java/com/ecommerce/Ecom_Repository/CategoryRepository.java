package com.ecommerce.Ecom_Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.Ecom_Model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    // Custom query methods can be defined here if needed
    
}
