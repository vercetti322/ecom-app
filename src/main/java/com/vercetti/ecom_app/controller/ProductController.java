package com.vercetti.ecom_app.controller;

import com.vercetti.ecom_app.model.Product;
import com.vercetti.ecom_app.model.ProductKey;
import com.vercetti.ecom_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    // get all the products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // get specific product
    @GetMapping("/products/{category}/{name}")
    public Product getProductByKey(
            @PathVariable String category,
            @PathVariable String name,
            @RequestParam String image) {
        ProductKey key = new ProductKey(image, name, category);
        return service.getProductByKey(key);
    }


    // get 9 random products for home preview
    @GetMapping("/products/preview")
    public List<Product> getProductPreview() {
        return service.getProductPreview();
    }

    // get 3 top-rated products per category
    @GetMapping("/products/category")
    public Map<String, List<Product>> getProductCategorical() {
        return service.getProductCategorical();
    }

    // get all products in a category
    @GetMapping("/products/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return service.getProductByCategory(category);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @PutMapping("/products")
    public void editProduct(@RequestBody Product product) {
        service.editProduct(product);
    }

    @DeleteMapping("/products")
    public void delProduct(@RequestBody Product product) {
        service.delProduct(product);
    }
}
