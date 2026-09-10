package com.mehmet.relationship.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mehmet.relationship.entity.Customer;
import com.mehmet.relationship.entity.Product;
import com.mehmet.relationship.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{productId}/customers")
    public List<Customer> getCustomersByProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return null;
        }

        return product.getCustomers();
    }
}