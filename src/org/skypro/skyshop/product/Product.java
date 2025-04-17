package org.skypro.skyshop.product;

public abstract class Product {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}
