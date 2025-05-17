package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.producttypes.DiscountedProduct;
import org.skypro.skyshop.product.producttypes.FixPriceProduct;
import org.skypro.skyshop.product.producttypes.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        //Создаем продукты
        try {
            Product incorrectProduct1 = new SimpleProduct(null, 180);
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректно заданы параметры продукта");
        }
        try {
            Product incorrectProduct2 = new DiscountedProduct("product", 180, 200);
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректно заданы параметры продукта");
        }
        Product bread = new SimpleProduct("Хлеб", 50);
        Product milk = new FixPriceProduct("Молоко");
        Product eggs = new DiscountedProduct("Яйца", 120, 20);
        Product cheese = new DiscountedProduct("Сыр", 152, 30);
        Product sausage = new SimpleProduct("Колбаса", 280);
        //Создаем корзину
        ProductBasket productBasket = new ProductBasket();
        //Добавляем продукты в корзину
        productBasket.addProduct(bread);
        productBasket.addProduct(milk);
        productBasket.addProduct(eggs);
        productBasket.addProduct(cheese);
        productBasket.addProduct(sausage);
        System.out.println("\nПечать содержимого корзины с несколькими товарами");
        productBasket.contentsOfTheBasket();
        System.out.println("\nПолучение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины: " + productBasket.basketCost());
        System.out.println("\nПоиск товара, который есть в корзине");
        System.out.println(productBasket.productExists("Хлеб"));
        System.out.println("\nПоиск товара, которого нет в корзине");
        System.out.println(productBasket.productExists("Творог"));
        //Удаляем существующий продукт из корзины
        System.out.println("\nУдаляем существующий продукт из корзины");
        List<Product> removingResult = productBasket.removeByName("Хлеб");
        System.out.println("Удаленные продукты:\n" + removingResult);
        System.out.println("\nСодержимое корзины после удаления продукта");
        productBasket.contentsOfTheBasket();
        System.out.println("\nПопытка удалить несуществующий продукт");
        removingResult = productBasket.removeByName("Творог");
        if (removingResult.isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println("\nСодержимое корзины после удаления несуществующего продукта");
        productBasket.contentsOfTheBasket();
        System.out.println("\nОчистка корзины");
        productBasket.emptyBasket();
        System.out.println("\nПечать содержимого пустой корзины");
        productBasket.contentsOfTheBasket();
        System.out.println("\nПолучение стоимости пустой корзины");
        System.out.println("Стоимость корзины: " + productBasket.basketCost());
        System.out.println("\nПоиск товара в пустой корзине по имени");
        System.out.println(productBasket.productExists("Молоко"));

        //Полиморфизм
        System.out.println("\nПолиморфизм и интерфейсы");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(eggs);
        searchEngine.add(cheese);
        searchEngine.add(sausage);
        Article article1 = new Article("Хлебная мудрость", "Лучше Хлеб с водою, чем пирог с бедою");
        Article article2 = new Article("Сырная мудрость", "Бесплатный Сыр бывает только в мышеловке. И только для второй мыши");
        searchEngine.add(article1);
        searchEngine.add(article2);
        System.out.println("\nРезультаты поиска Хлеб:");
        printSearchResult(searchEngine.search("Хлеб"));
        System.out.println("\nРезультаты поиска Сыр:");
        printSearchResult(searchEngine.search("Сыр"));
        System.out.println("\nРезультаты поиска л:");
        printSearchResult(searchEngine.search("л"));
        //Новый метод поиска
        System.out.println("\nНовый метод поиска");
        try {
            System.out.println("Попытка поиска существующего элемента...");
            System.out.println(searchEngine.getTheBestSearchResult("ро").getStringRepresentation());
            System.out.println("Попытка поиска несуществующего элемента...");
            System.out.println(searchEngine.getTheBestSearchResult("jnbsvad").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено подходящей статьи");
        }
    }

    public static void printSearchResult(Map<String, Searchable> searchResults) {
        for (Searchable result : searchResults.values()) {
            System.out.println(result.getStringRepresentation());
        }
    }
}
