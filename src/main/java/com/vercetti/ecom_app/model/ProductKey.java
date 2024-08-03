package com.vercetti.ecom_app.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductKey implements Serializable {
    private String image;
    private String name;
    private String category;

    // default constructor
    public ProductKey() {}

    // all args constructor
    public ProductKey(String image, String name, String category) {
        this.image = image;
        this.name = name;
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, name, category);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        ProductKey key = (ProductKey) object;
        return Objects.equals(image, key.image) &&
                Objects.equals(name, key.name) &&
                Objects.equals(category, key.category);
    }
}
