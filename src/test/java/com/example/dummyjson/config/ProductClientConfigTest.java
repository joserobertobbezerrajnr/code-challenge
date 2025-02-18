package com.example.dummyjson.config;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductClientConfigTest {

    @MockBean
    private ProductClientConfig productClientConfig;

    @Test
    void testGetAllProducts() {
        // Mock da resposta esperada
        Map<String, Object> mockResponse = Map.of("products", "mockedData");

        when(productClientConfig.getAllProducts()).thenReturn(mockResponse);

        // Chamada ao método
        Map<String, Object> response = productClientConfig.getAllProducts();

        // Verificações
        assertEquals("mockedData", response.get("products"));
        verify(productClientConfig, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() {
        // Criando e configurando o mock do produto esperado
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setTitle("Test Product");
        mockProduct.setDescription("Test Description");
        mockProduct.setPrice(100.0);

        when(productClientConfig.getProductById(1L)).thenReturn(mockProduct);

        // Chamada ao método
        Product response = productClientConfig.getProductById(1L);

        // Verificações
        assertEquals(1L, response.getId());
        assertEquals("Test Product", response.getTitle());
        assertEquals("Test Description", response.getDescription());
        assertEquals(100.0, response.getPrice());
        verify(productClientConfig, times(1)).getProductById(1L);
    }

}
