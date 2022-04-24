package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.Bill;
import com.example.wp_project_original.model.Product;
import com.example.wp_project_original.model.exceptions.InvalidBillIdException;
import com.example.wp_project_original.model.exceptions.InvalidProductIdException;
import com.example.wp_project_original.repository.BillRepository;
import com.example.wp_project_original.repository.ProductRepository;
import com.example.wp_project_original.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final ProductRepository productRepository;

    public BillServiceImpl(BillRepository billRepository, ProductRepository productRepository) {
        this.billRepository = billRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Bill create(Integer brMasa, List<Product> productList) {
        Bill bill = new Bill(brMasa,productList);
        this.billRepository.save(bill);
        return bill;
    }

    @Override
    public Bill update(Long id, Integer brMasa, List<Product> productList) {
        Bill bill = this.findById(id);
        bill.setBrMasa(brMasa);
        bill.setProductList(productList);
        this.billRepository.save(bill);
        return bill;
    }

    @Override
    public Bill findById(Long id) {
        return this.billRepository.findById(id).orElseThrow(InvalidBillIdException::new);
    }

    @Override
    public List<Bill> findAll() {
        return this.billRepository.findAll();
    }

    @Override
    public Product deleteProduct(Long idSmetka, Long idProduct) {
        Bill bill = this.findById(idSmetka);
        List<Product> productList = bill.getProductList();
        Product product = new Product();
        for(int i=0;i<productList.size();i++){
            if( productList.get(i).getId().equals(idProduct) ){
                product = productList.get(i);
                productList.remove(product);
            }
        }
        return product;
    }

    @Override
    public Product addProduct(Long idSmetka, Long idProduct) {
        Bill bill = this.findById(idSmetka);
        Product product = this.productRepository.findById(idProduct).orElseThrow(InvalidProductIdException::new);
        List<Product> productList = bill.getProductList();
        productList.add(product);
        bill.setProductList(productList);
        this.billRepository.save(bill);
        return product;
    }

    @Override
    public void deleteBill(Long id) {
        this.billRepository.deleteById(id);
    }
}
