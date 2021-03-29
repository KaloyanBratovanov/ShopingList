package com.ex.shop.service;

import com.ex.shop.model.entity.enums.CategoryName;
import com.ex.shop.model.service.ProductServiceModel;
import com.ex.shop.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {


    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

    void buyById(String id);

    void buyAll();

}
