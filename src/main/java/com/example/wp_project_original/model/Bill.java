package com.example.wp_project_original.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue
    private Long id;

    private Integer brMasa;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> productList;

    public Bill(Integer brMasa, List<Product> productList){
        this.productList = new ArrayList<>();
        this.brMasa = brMasa;
    }

    public Bill(){

    }

    public Long getId() {
        return id;
    }

    public Integer getBrMasa() {
        return brMasa;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrMasa(Integer brMasa) {
        this.brMasa = brMasa;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
