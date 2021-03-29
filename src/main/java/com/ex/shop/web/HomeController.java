package com.ex.shop.web;

import com.ex.shop.model.entity.enums.CategoryName;
import com.ex.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private  final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){

        if (httpSession.getAttribute("user")== null){

            return "index";
        }


        model.addAttribute("totalSum",productService.getTotalSum());

        model.addAttribute("drinks", productService
                .findAllProductsByCategoryName(CategoryName.DRINK));

        model.addAttribute("food", productService
                .findAllProductsByCategoryName(CategoryName.FOOD));

        model.addAttribute("household", productService
                .findAllProductsByCategoryName(CategoryName.HOUSEHOLD));

        model.addAttribute("other", productService
                .findAllProductsByCategoryName(CategoryName.OTHER));


        return "home";
    }
}
