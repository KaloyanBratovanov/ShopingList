package com.ex.shop.repositoty;

import com.ex.shop.model.entity.Product;
import com.ex.shop.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, String> {


    @Query("SELECT SUM(p.price )FROM Product p ")
    BigDecimal findTotalProductSum();

    List<Product>findAllByCategory_Name(CategoryName name);


}
