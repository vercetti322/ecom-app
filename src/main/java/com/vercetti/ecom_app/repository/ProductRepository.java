package com.vercetti.ecom_app.repository;

import com.vercetti.ecom_app.model.Product;
import com.vercetti.ecom_app.model.ProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductKey> {

    @Query("select p.productKey from Product p")
    List<ProductKey> getAllProductKeys();

    @Query("select p.productKey.category from Product p")
    List<String> getAllCategories();

    @Query("select p from Product p where p.productKey.category = :category order by p.rating desc")
    List<Product> findTopProducts(String category, Pageable pageable);

    @Query("select p from Product p where p.productKey.category = :category")
    List<Product> findProductsCategorical(String category);
}
