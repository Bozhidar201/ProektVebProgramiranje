package com.example.wp_project_original.config;

import com.example.wp_project_original.model.*;
import com.example.wp_project_original.model.enumerations.Role;
import com.example.wp_project_original.service.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final UserService userService;
    private final ProductService productService;
    private final BillService billService;
    private final ManufacturerService manufacturerService;
    private final EventService eventService;
    private final MonthlyAgendaService monthlyAgendaService;

    public DataInitializer(UserService userService, ProductService productService, BillService billService, ManufacturerService manufacturerService, EventService eventService, MonthlyAgendaService monthlyAgendaService) {
        this.userService = userService;
        this.productService = productService;
        this.billService = billService;
        this.manufacturerService = manufacturerService;
        this.eventService = eventService;
        this.monthlyAgendaService = monthlyAgendaService;
    }

    @PostConstruct
    public void initData(){
        // KREIRANJE MANUFACTURER
        this.manufacturerService.create("Jack Daniels", "USA");
        this.manufacturerService.create("Stek", "Kina");
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        //1. DODAVANJE USER
        User user = new User("admin", "admin", Role.ROLE_ADMIN);
        this.userService.create("admin", "admin", Role.ROLE_ADMIN);
        //2. DODAVANJE PRODUKTI VO DATA BAZA
        this.productService.create("Cheese cake", "Desert", 140.0, 30,manufacturers.get(1));
        this.productService.create("Pizza", "Glavno jadenje", 290.0,50,manufacturers.get(1));
        this.productService.create("Piroshka", "Dodatok", 130.0, 40,manufacturers.get(1));
        this.productService.create("Sladoled", "Desert", 120.0, 45,manufacturers.get(1));
        this.productService.create("Zlaten Dab", "Pivo", 90.0, 80,manufacturers.get(1));
        this.productService.create("Skopsko", "Pivo", 90.0, 80,manufacturers.get(1));
        this.productService.create("Bravo", "Gust sok", 70.0, 70,manufacturers.get(1));
        this.productService.create("Jack Daniels", "Zhestok pijalok", 2700.0, 200,manufacturers.get(1));
        this.productService.create("Cezar", "Salata predjadenje", 230.0, 100,manufacturers.get(1));
        this.productService.create("Coca cola", "Osvezhitelen gaziran pijalok", 80.0, 200,manufacturers.get(1));
        this.productService.create("Fanta", "Osvezhitelen gaziran pijalok", 80.0, 100,manufacturers.get(1));
        this.productService.create("Topla daska", "Topla daska Description", 480.0, 100,manufacturers.get(1));
        this.productService.create("Espresso", "Kafe", 50.0, 100,manufacturers.get(1));
        this.productService.create("Meshana salata", "Marula salata", 100.0,40,manufacturers.get(1));
        this.productService.create("Shopska salata", "Domati, krastavica i sirenje", 100.0, 30,manufacturers.get(1));
        this.productService.create("Caziki", "Pavlaka, krastavica, luk", 80.0, 20,manufacturers.get(1));
        this.productService.create("Turshija", "Salata", 60.0, 40,manufacturers.get(1));
        //3. DODAVANJE PRODUKTI VO LISTA ZA SMETKA
        List<Product> productList = new ArrayList<>();
        List<Product> productList1 = new ArrayList<>();
        List<Product> productList2 = new ArrayList<>();
        Product p = new Product("Jack Daniels", "Zhestok pijalok", 2700.0, 2,manufacturers.get(1));
        productList.add(p);
        Product p1 = new Product("Cezar", "Salata predjadenje", 230.0, 1,manufacturers.get(1));
        productList.add(p1);
        Product p2 = new Product("Coca cola", "Osvezhitelen gaziran pijalok", 80.0, 2,manufacturers.get(1));
        productList1.add(p2);
        Product p3 = new Product("Fanta", "Osvezhitelen gaziran pijalok", 80.0, 1,manufacturers.get(1));
        productList1.add(p3);
        Product p4 = new Product("Topla daska", "Topla daska Description", 480.0, 1,manufacturers.get(1));
        productList2.add(p4);
        Product p5 = new Product("Espresso", "Kafe", 50.0, 1,manufacturers.get(1));
        productList2.add(p5);
        // KREIRANJE NA SMETKI
        //Bill b1 = this.billService.create(5, productList);
        //Bill b2 = this.billService.create(6, productList1);
        //Bill b3 = this.billService.create(7, productList2);


        // KREIRANJE NA EVENTI VO DATA BAZA
        this.eventService.create("Petok(03.12) 21:00","R'n'B Neighbors", "Live Rock");
        this.eventService.create("Sabota(04.12) 21:00","DJ Popeye", "Hip Hop DJ");
        this.eventService.create("Petok(10.12) 21:00","Chicks", "POP");
        this.eventService.create("Sabota(11.12) 21:00","Journal", "Live Rock");
        this.eventService.create("Petok(17.12) 21:00","4U Band", "Live Rock");
        this.eventService.create("Sabota(18.12) 21:00","Blue Band", "Pop");
        this.eventService.create("Petok(24.12) 21:00","Dopamine", "Live Rock");
        this.eventService.create("Sabota(25.12) 21:00","Light Night", "Live Rock");
        this.eventService.create("Sreda(29.12) 21:00","Journal", "Live Rock");
        this.eventService.create("Chetvrtok(30.12) 21:00","4U Band", "Live Rock");

        // KREIRANJE LISTA OD EVENTI ZA VO MONTHLY AGENDA
        List<Event> eventList = this.eventService.findAll();

        MonthlyAgenda monthlyAgenda = this.monthlyAgendaService.create("Dekemvri", eventList);
        monthlyAgenda.setEventList(eventList);

    }
}
