package com.example.wp_project_original.web;

import com.example.wp_project_original.model.Bill;
import com.example.wp_project_original.model.Product;
import com.example.wp_project_original.service.BillService;
import com.example.wp_project_original.service.ProductService;
import com.example.wp_project_original.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BillsController {

    private final ProductService productService;
    private final BillService billService;

    public BillsController(ProductService productService, UserService userService, BillService billService) {
        this.productService = productService;
        this.billService = billService;
    }

    @GetMapping("/bills")
    public String showListBills(Model model, HttpServletRequest request){
        model.addAttribute("bills", this.billService.findAll());
        Bill bill = (Bill) request.getSession().getAttribute("smetka");
        model.addAttribute("smetka", bill);
        return "bills.html";
    }

    @PostMapping("/bills/showBill")
    public String showBill(@RequestParam Long showBill, Model model, HttpServletRequest request){
        Bill bill = this.billService.findById(showBill);
        request.getSession().setAttribute("smetka", bill);
        return "redirect:/bills";
    }

    @PostMapping("/addNewBill")
    public String addNewBill(@RequestParam Integer brMasa){
        List<Product> productList = new ArrayList<>();
        System.out.println(brMasa);
        this.billService.create(brMasa, productList);
        return "redirect:/bills";
    }

    @PostMapping("/addProductToBill")
    public String addProductToBill(@RequestParam Long idProduct, HttpServletRequest request, Model model){
        Bill bill = (Bill) request.getSession().getAttribute("smetka");
        this.billService.addProduct(bill.getId(), idProduct);
        return "redirect:/bills";
    }

}
