package org.skypro.skyshop.product.producttypes;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 50;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
