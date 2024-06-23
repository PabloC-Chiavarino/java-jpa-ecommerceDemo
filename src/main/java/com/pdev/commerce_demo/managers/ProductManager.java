package com.pdev.commerce_demo.managers;

import com.pdev.commerce_demo.entities.Product;

public class ProductManager extends _GenericManager<Product> {

    public ProductManager() throws Exception {
        super(Product.class);
    }
}
