package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        // Valores esperados
        Long expectedId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = 2.1;

        // Cria um objeto Product e define os valores
        Product product = new Product();
        product.setId(expectedId);
        product.setTitle(expectedTitle);
        product.setDescription(expectedDescription);
        product.setPrice(expectedPrice);

        // Verifica se os valores foram atribuídos corretamente
        assertEquals(expectedId, product.getId(), "ID do produto não corresponde ao esperado");
        assertEquals(expectedTitle, product.getTitle(), "Título do produto não corresponde ao esperado");
        assertEquals(expectedDescription, product.getDescription(), "Descrição do produto não corresponde ao esperado");
        assertEquals(expectedPrice, product.getPrice(), "Preço do produto não corresponde ao esperado");
    }
}
