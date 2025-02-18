package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.config.ProductClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductClientConfig productClientConfig;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        Map<String, Object> mockedResponse = createMockedResponse();
        when(productClientConfig.getAllProducts()).thenReturn(mockedResponse);

        List<Map<String, Object>> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).get("title"));
        assertEquals("Product 2", result.get(1).get("title"));
    }

    private Map<String, Object> createMockedResponse() {
        List<Map<String, Object>> productsList = Arrays.asList(
                createProductMap(1L, "Product 1", "Description 1", 100.0),
                createProductMap(2L, "Product 2", "Description 2", 150.0)
        );
        Map<String, Object> mockedResponse = new HashMap<>();
        mockedResponse.put("products", productsList);
        return mockedResponse;
    }

    private Map<String, Object> createProductMap(Long id, String title, String description, Double price) {
        return Map.of(
                "id", id,
                "title", title,
                "description", description,
                "price", price
        );
    }

    @Test
    public void testGetProductById() {
        Product product = createProduct(1L, "Product 1", "Description 1", 100.0);
        when(productClientConfig.getProductById(1L)).thenReturn(product);

        Product result = productService.getProductById(1L);

        assertEquals("Product 1", result.getTitle());
        assertEquals("Description 1", result.getDescription());
        assertEquals(100.0, result.getPrice());
    }

    private Product createProduct(Long id, String title, String description, Double price) {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        return product;
    }
}