package com.ex.shop.service.impl;

import com.ex.shop.model.entity.Product;
import com.ex.shop.model.entity.enums.CategoryName;
import com.ex.shop.model.service.ProductServiceModel;
import com.ex.shop.model.view.ProductViewModel;
import com.ex.shop.repositoty.ProductsRepository;
import com.ex.shop.service.CategoryService;
import com.ex.shop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductsRepository productsRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void add(ProductServiceModel productServiceModel) {

        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productsRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {

        return productsRepository.findTotalProductSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName) {
        return productsRepository.findAllByCategory_Name(categoryName)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productsRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productsRepository.deleteAll();
    }
}
