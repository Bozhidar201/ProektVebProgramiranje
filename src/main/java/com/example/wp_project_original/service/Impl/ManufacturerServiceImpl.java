package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.Manufacturer;
import com.example.wp_project_original.model.exceptions.InvalidManufacturerIdException;
import com.example.wp_project_original.repository.ManufacturerRepository;
import com.example.wp_project_original.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Long id) {
        return this.manufacturerRepository.findById(id).orElseThrow(InvalidManufacturerIdException::new);
    }

    @Override
    public Manufacturer create(String name, String country) {
        Manufacturer manufacturer = new Manufacturer(name,country);
        this.manufacturerRepository.save(manufacturer);
        return manufacturer;
    }

    @Override
    public void delete(Long id) {
        this.manufacturerRepository.deleteById(id);
    }
}
