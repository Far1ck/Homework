package org.skypro.skyshop.product.producttypes;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private int productBasePrice;
    private int discount;

    public DiscountedProduct(String productName, int productPrice, int discount) {
        super(productName);
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100");
        }
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
