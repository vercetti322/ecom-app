package com.vercetti.ecom_app.service;

import com.vercetti.ecom_app.model.Product;
import com.vercetti.ecom_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id)
                .orElse(new Product());
    }

    public List<Product> getProductPreview() {
        List<Integer> allIds = repository.getAllIds();
        Collections.shuffle(allIds);
        List<Integer> reqIds =  allIds.stream().limit(9).toList();

        List<Product> reqProducts = new java.util.ArrayList<>(List.of());
        for (int id: reqIds) {
            Product product = getProductById(id);
            reqProducts.add(product);
        }

        return reqProducts;
    }
}
