package com.vercetti.ecom_app.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product {

    @EmbeddedId
    private ProductKey productKey;

    @Column(nullable = false)
    private String brand;

    @Column(length = 1000)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private boolean available;

    @Column(nullable = false)
    private float rating;

    // all args Constructor
    public Product(ProductKey productKey, String description, String brand, BigDecimal price, Date releaseDate, int quantity, Boolean available, float rating) {
        this.productKey = productKey;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
        this.available = available;
        this.rating = rating;
    }

    // update constructor
    public void updateFrom(Product newProduct) {
        this.description = newProduct.getDescription();
        this.brand = newProduct.getBrand();
        this.price = newProduct.getPrice();
        this.releaseDate = newProduct.getReleaseDate();
        this.quantity = newProduct.getQuantity();
        this.available = newProduct.isAvailable();
        this.rating = newProduct.getRating();
    }

    // no args constructor
    public Product() { }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ProductKey getProductKey() {
        return productKey;
    }

    public void setProductKey(ProductKey productKey) {
        this.productKey = productKey;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
