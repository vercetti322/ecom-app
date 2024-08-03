package com.vercetti.ecom_app.repository;

import com.vercetti.ecom_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p.id from Product p")
    List<Integer> getAllIds();
}
