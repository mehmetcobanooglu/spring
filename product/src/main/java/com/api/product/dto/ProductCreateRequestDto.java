package com.api.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductCreateRequestDto {

    @NotBlank(message = "Ürün Adı Boş Bırakılamaz")
    private String name;

    @NotNull(message = "Fiyat Boş Bırakılamaz")
    @Min(value = 0, message = "Fiyat Negatif Olamaz")
    private Double price;

    @NotNull(message = "Stok Boş Bırakılamaz")
    @Min(value = 0, message = "Stok negatif olamaz")
    private Integer stock;

    @NotBlank(message = "Kategori Boş Bırakılamaz")
    private String category;

    public ProductCreateRequestDto() {

    }

    public ProductCreateRequestDto(String name, Double price, Integer stock, String category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}