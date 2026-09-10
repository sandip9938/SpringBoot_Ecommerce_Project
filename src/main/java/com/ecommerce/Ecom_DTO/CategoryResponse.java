package com.ecommerce.Ecom_DTO;

import java.util.List;

import lombok.Data;
@Data
public class CategoryResponse {

  private List<CategoryDTO> content;
  public List<CategoryDTO> getContent() {
    return this.content;
  }

  public void setContent(List<CategoryDTO> content) {
    this.content = content;
  }
    
}
