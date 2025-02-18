package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.config.ProductClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductClientConfig productClientConfig;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAllProducts() {
        Map<String, Object> response = productClientConfig.getAllProducts();
        return (List<Map<String, Object>>) response.get("products");
    }

    public Product getProductById(Long id) {
        return productClientConfig.getProductById(id);
    }
}
