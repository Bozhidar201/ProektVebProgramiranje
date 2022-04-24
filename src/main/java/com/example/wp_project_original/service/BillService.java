package com.example.wp_project_original.service;

import com.example.wp_project_original.model.Bill;
import com.example.wp_project_original.model.Product;

import java.util.List;

public interface BillService {
    Bill create(Integer brMasa, List<Product> productList);
    Bill update(Long id, Integer brMasa, List<Product> productList);
    Bill findById(Long id);
    List<Bill> findAll();
    Product deleteProduct(Long idSmetka,Long idProduct);
    Product addProduct(Long idSmetka, Long idProduct);
    void deleteBill(Long id);
}
