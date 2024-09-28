package com.example.product;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
		assertNotNull(productService, "El servicio ProductService no debería ser nulo si el contexto se carga correctamente.");
	}

	@Test
	void testProductServiceFunctionality() {
		String productName = productService.getProductNameById(1L);
		assertNotNull(productName, "El nombre del producto no debería ser nulo.");
	}
}
