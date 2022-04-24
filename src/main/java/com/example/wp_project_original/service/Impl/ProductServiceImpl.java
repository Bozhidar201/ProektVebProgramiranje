package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.Manufacturer;
import com.example.wp_project_original.model.Product;
import com.example.wp_project_original.model.User;
import com.example.wp_project_original.model.exceptions.InvalidProductIdException;
import com.example.wp_project_original.repository.ProductRepository;
import com.example.wp_project_original.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(InvalidProductIdException::new);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Product create(String name, String description, Double price, Integer quantity, Manufacturer manufacturer) {
        Product product = new Product(name,description,price,quantity, manufacturer);
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product edit(Long id, String name, String description, Double price, Integer quantity,Manufacturer manufacturer) {
        Product product = this.findById(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setManufacturer(manufacturer);
        this.productRepository.save(product);
        return product;
    }
}
