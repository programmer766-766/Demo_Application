package com.demo.application.controller;

import com.demo.application.dtos.DemoProducts;
import com.demo.application.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/demo-products")
    public ResponseEntity<List<DemoProducts>> getAllDemoProducts(){
        return ResponseEntity.ok(productService.getAllDemoProducts());
    }
}
