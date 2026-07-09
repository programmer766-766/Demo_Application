package com.demo.application.service;

import com.demo.application.dtos.DemoProducts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService {
    //method for list an demo products
    private List<DemoProducts> listDemoProducts(){

        return new ArrayList<>(List.of(
                new DemoProducts(1, "Mobile phone", 7000.23, LocalDate.now()),
                new DemoProducts(2, "Jio Phone", 2000.39, LocalDate.now().plusDays(3)),
                new DemoProducts(3, "Panasonic Tv", 45000.46, LocalDate.now().plusDays(2)),
                new DemoProducts(4, "Fridge", 20000.23, LocalDate.now().plusDays(5)),
                new DemoProducts(5, "Ac", 50000.00, LocalDate.now().plusDays(5))
        ));
    }
    //method will return some demo products
    public List<DemoProducts> getAllDemoProducts(){
        return listDemoProducts();
    }
}
