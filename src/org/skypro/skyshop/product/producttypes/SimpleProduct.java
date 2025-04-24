package org.skypro.skyshop.product.producttypes;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    private int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.productPrice = productPrice;
    }

    @Override
    public int getPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
