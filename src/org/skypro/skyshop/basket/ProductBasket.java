package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (!products.containsKey(product.getName())) {
            products.put(product.getName(), new ArrayList<>());
        }
        products.get(product.getName()).add(product);
    }

    public int basketCost() {
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void contentsOfTheBasket() {
        boolean basketIsEmpty = true;
        int countOfSpecialProducts = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
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
        return products.containsKey(productName);
    }

    public void emptyBasket() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> result = new LinkedList<>();
        for (Map.Entry<String, List<Product>> productList : products.entrySet()) {
            if (productList.getKey().equals(name)) {
                result.addAll(productList.getValue());
            }
        }
        products.remove(name);
        return result;
    }
}
