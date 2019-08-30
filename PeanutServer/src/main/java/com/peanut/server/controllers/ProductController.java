package com.peanut.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peanut.server.models.Product;
import com.peanut.server.repositories.ProductRepository;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }
}