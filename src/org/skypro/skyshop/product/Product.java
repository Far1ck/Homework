package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public String getSearchTerm() {
        return productName;
    }

    public String getTypeOfContent() {
        return "PRODUCT";
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}

