package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products = new Product[5];
    private boolean basketIsFull = false;

    public void addProduct(Product product) {
        if (!basketIsFull) {
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = product;
                    basketIsFull = i == 4;
                    break;
                }
            }
        }
        else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int basketCost() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getProductCost();
            }
        }
        return sum;
    }

    public void contentsOfTheBasket() {
        boolean basketIsEmpty = true;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                basketIsEmpty = false;
            }
        }
        if (basketIsEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + basketCost());
        }
    }

    public boolean productExists(String productName) {
        boolean result = false;
        for (Product product : products) {
            if (product != null && product.getProductName().equals(productName)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void emptyBasket() {
        Arrays.fill(products, null);
    }
}
