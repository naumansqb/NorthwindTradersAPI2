package com.pluralsight.NorthwindTradersAPI2.controllers;

import com.pluralsight.NorthwindTradersAPI2.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> products;

    public ProductsController(){
        products=new ArrayList<>();
        products.add(new Product(1, "john", 1, 18.00));
        products.add(new Product(2, "Cena", 1, 19.00));
        products.add(new Product(3, "WWE", 2, 10.00));
    }

    @RequestMapping(path="/products",method = RequestMethod.GET)
    public List<Product> getAllProducts (){
        return products;
    }

    @RequestMapping(path = "/products/{productId}",method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId){
        for (Product product : products) {
            if(product.getProductId() == productId){
                return product;
            }
        }
        return  null;
    }
}
