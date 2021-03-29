package com.ex.shop.service;

import com.ex.shop.model.entity.Category;
import com.ex.shop.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);

}
