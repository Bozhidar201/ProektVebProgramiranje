package com.example.wp_project_original.service;

import com.example.wp_project_original.model.Manufacturer;
import com.example.wp_project_original.model.Product;
import com.example.wp_project_original.model.User;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    void delete(Long id);
    Product create(String name, String description, Double price, Integer quantity, Manufacturer manufacturer);
    Product edit(Long id,String name, String description, Double price, Integer quantity, Manufacturer manufacturer);
}
