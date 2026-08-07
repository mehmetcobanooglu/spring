package com.api.product.dto;

public class ProductResponseDto {

    private Long id;
    private String name;
    private Double price;
    private String categori;
    private Integer stock;

    public ProductResponseDto(Long id, String name, Double price, Integer stock, String categori) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categori = categori;
        this.stock = stock;
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

    public String getCategori() {
        return categori;
    }

    public void setCategori(String categori) {
        this.categori = categori;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
