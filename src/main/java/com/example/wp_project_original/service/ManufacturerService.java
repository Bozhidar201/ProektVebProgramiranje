package com.example.wp_project_original.service;

import com.example.wp_project_original.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    Manufacturer findById(Long id);
    Manufacturer create(String name, String country);
    void delete(Long id);
}
