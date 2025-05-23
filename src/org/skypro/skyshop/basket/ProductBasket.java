package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

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
        return products.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void contentsOfTheBasket() {
        products.values().stream().flatMap(Collection::stream)
                .forEach(System.out::println);
        int countOfSpecialProducts = getSpecialCount();
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + basketCost());
        }
        System.out.println("Специальных товаров: " + countOfSpecialProducts);
    }

    private int getSpecialCount() {
        return (int)products.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean productExists(String productName) {
        return products.containsKey(productName);
    }

    public void emptyBasket() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> result = products.entrySet().stream()
                .filter(productEntry -> productEntry.getKey().equals(name))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedList::new));
        products.remove(name);
        return result;
    }
}
