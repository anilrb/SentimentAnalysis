package com.example1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class Product {

    @GetMapping
    public String getProduct(){
        return "Hello Boys";
    }
}
