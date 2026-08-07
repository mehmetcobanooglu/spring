package com.api.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.product.dto.ProductCreateRequestDto;
import com.api.product.dto.ProductResponseDto;
import com.api.product.entity.Product;
import com.api.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto saveProduct(ProductCreateRequestDto dto) {

        // DTO -> Entity dönüşümü
        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory(dto.getCategory());

        // Veritabanına kayıt
        Product savedProduct = productRepository.save(product);

        // Entity -> Response DTO dönüşümü
        ProductResponseDto responseDto = new ProductResponseDto(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getStock(),
                savedProduct.getCategory());

        return responseDto;
    }

    public List<ProductResponseDto> getAllProducts() {

        List<Product> s = productRepository.findAll();

        List<ProductResponseDto> a = new ArrayList<>();

        for (Product c : s) {

            ProductResponseDto b = new ProductResponseDto(c.getId(), c.getName(), c.getPrice(), c.getStock(),
                    c.getCategory());
            a.add(b);
        }
        return a;
    }
}