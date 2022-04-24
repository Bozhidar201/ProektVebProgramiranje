package com.example.wp_project_original.web;

import com.example.wp_project_original.model.Manufacturer;
import com.example.wp_project_original.model.Product;
import com.example.wp_project_original.service.ManufacturerService;
import com.example.wp_project_original.service.ProductService;
import com.example.wp_project_original.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private final ProductService productService;
    private final UserService userService;
    private final ManufacturerService manufacturerService;
    public ProductsController(ProductService productService, UserService userService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.userService = userService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/products")
    public String showProducts(Model model){
        model.addAttribute("products", this.productService.findAll());
        return "products.html";
    }

    @GetMapping("/products/add")
    public String showAddProduct(Model model){
        model.addAttribute("manufacturers", this.manufacturerService.findAll());
        return "formAddEditProduct.html";
    }

    @GetMapping("/products/{id}/edit")
    public String showEditProduct(@PathVariable Long id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("manufacturers", this.manufacturerService.findAll());
        return "formAddEditProduct.html";
    }

    @PostMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable Long id){
        this.productService.delete(id);
        return "redirect:/products";
    }

    @PostMapping("/products/{id}")
    public String editProduct(@PathVariable Long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Double price,
                              @RequestParam Integer quantity,
                              @RequestParam Long manufacturer){
        Manufacturer m1 = this.manufacturerService.findById(manufacturer);
        this.productService.edit(id,name,description,price,quantity,m1);
        return "redirect:/products";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Double price,
                             @RequestParam Integer quantity,
                             @RequestParam Long manufacturer){
        Manufacturer m1 = this.manufacturerService.findById(manufacturer);
        this.productService.create(name,description,price,quantity,m1);
        return "redirect:/products";
    }
}
