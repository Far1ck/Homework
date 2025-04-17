package org.skypro.skyshop.product.producttypes;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private int productBasePrice;
    private int discount;

    public DiscountedProduct(String productName, int productPrice, int discount) {
        super(productName);
        this.productBasePrice = productPrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return productBasePrice - (productBasePrice / 100 * discount);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
