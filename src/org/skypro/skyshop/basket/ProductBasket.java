package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public int basketCost() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void contentsOfTheBasket() {
        boolean basketIsEmpty = true;
        int countOfSpecialProducts = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                countOfSpecialProducts = product.isSpecial() ? countOfSpecialProducts + 1 : countOfSpecialProducts;
                basketIsEmpty = false;
            }
        }
        if (basketIsEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + basketCost());
        }
        System.out.println("Специальных товаров: " + countOfSpecialProducts);
    }

    public boolean productExists(String productName) {
        boolean result = false;
        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void emptyBasket() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> result = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        Product element;
        while (iterator.hasNext()) {
            element = iterator.next();
            if (element.getName().equals(name)) {
                result.add(element);
                iterator.remove();
            }
        }
        return result;
    }
}
