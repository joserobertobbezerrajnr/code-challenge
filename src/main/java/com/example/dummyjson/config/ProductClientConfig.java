package com.example.dummyjson.config;

import com.example.dummyjson.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "productClientConfig", url = "https://dummyjson.com/products")
public interface ProductClientConfig {

    @GetMapping
    Map<String, Object> getAllProducts();

    @GetMapping("/{id}")
    Product getProductById(@PathVariable("id") Long id);
}