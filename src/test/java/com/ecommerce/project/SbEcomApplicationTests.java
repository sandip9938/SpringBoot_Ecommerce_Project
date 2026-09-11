package com.ecommerce.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.Ecom_DTO.CategoryDTO;

@SpringBootTest
class SbEcomApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void categoryDto_shouldCarryName() {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryName("Electronics");
		assertEquals("Electronics", categoryDTO.getCategoryName());
	}

}
