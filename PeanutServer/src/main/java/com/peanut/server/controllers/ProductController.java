package com.peanut.server.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/products")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping(path = "/products")
    public Product addProduct(@RequestBody Product product) {
        Product pt = productRepository.save(product);
        System.out.println(pt);
        return pt;
    }

    @PutMapping("/products/{id}")
    ResponseEntity<Product> replaceProduct(@RequestBody Product product, @PathVariable long id) {

        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()) {
        	Product _product = productData.get();
            _product.setProdName(product.getProdName());
            _product.setProdDesc(product.getProdDesc());
            _product.setProdPrice(product.getProdPrice());

            return new ResponseEntity<Product> (productRepository.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable long id) {
    	
        //productRepository.deleteById(id); this method can only delete objects with String id
        Optional<Product> productData = productRepository.findById(id);
        productRepository.delete(productData.get());
    }
}