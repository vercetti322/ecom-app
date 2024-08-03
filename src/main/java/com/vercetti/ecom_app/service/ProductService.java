package com.vercetti.ecom_app.service;

import com.vercetti.ecom_app.model.Product;
import com.vercetti.ecom_app.model.ProductKey;
import com.vercetti.ecom_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getTopProducts(String category, int topN) {
        Pageable pageable = PageRequest.of(0, topN);
        return repository.findTopProducts(category, pageable);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductByKey(ProductKey productKey) {
        return repository.findById(productKey)
                .orElse(new Product());
    }

    public List<Product> getProductPreview() {
        List<ProductKey> allKeys = repository.getAllProductKeys();
        Collections.shuffle(allKeys);
        List<ProductKey> reqKeys =  allKeys.stream().limit(9).toList();

        List<Product> reqProducts = new java.util.ArrayList<>(List.of());
        for (ProductKey key: reqKeys) {
            Product product = getProductByKey(key);
            reqProducts.add(product);
        }

        return reqProducts;
    }

    public void addProduct(Product product) {
        ProductKey Key = product.getProductKey();
        Optional<Product> existing = repository.findById(Key);

        if (existing.isPresent())
            throw new IllegalArgumentException("Product with given key exists....");

        repository.save(product);
    }

    public void editProduct(Product product) {
        ProductKey Key = product.getProductKey();
        Optional<Product> existingOptional = repository.findById(Key);

        if (existingOptional.isPresent()) {
            Product existing = existingOptional.get();
            existing.updateFrom(product);
            repository.save(existing);
        } else {
            throw new IllegalArgumentException("product is NOT present...");
        }
    }

    public void delProduct(Product product) {
        ProductKey Key = product.getProductKey();
        Optional<Product> existing = repository.findById(Key);

        if (existing.isEmpty())
            throw new IllegalArgumentException("Product does NOT exist....");

        repository.delete(product);
    }

    public Map<String, List<Product>> getProductCategorical() {
        List<String> categories = repository.getAllCategories();
        Map<String, List<Product>> categoricalProducts = new HashMap<>();

        for (String category: categories) {
            categoricalProducts.put(category, getTopProducts(category, 3));
        }

        return categoricalProducts;
    }

    public List<Product> getProductByCategory(String category) {
        return repository.findProductsCategorical(category);
    }
}
