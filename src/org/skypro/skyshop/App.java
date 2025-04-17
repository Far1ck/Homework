package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.producttypes.DiscountedProduct;
import org.skypro.skyshop.product.producttypes.FixPriceProduct;
import org.skypro.skyshop.product.producttypes.SimpleProduct;

public class App {
    public static void main(String[] args) {
        //Создаем продукты
        Product bread = new SimpleProduct("Хлеб", 50);
        Product milk = new FixPriceProduct("Молоко");
        Product eggs = new DiscountedProduct("Яйца", 120, 20);
        Product cheese = new DiscountedProduct("Сыр", 152, 30);
        Product sausage = new SimpleProduct("Колбаса", 280);
        Product cottageCheese = new SimpleProduct("Творог", 112);
        //Создаем корзину
        ProductBasket productBasket = new ProductBasket();
        //Добавляем продукты в корзину
        productBasket.addProduct(bread);
        productBasket.addProduct(milk);
        productBasket.addProduct(eggs);
        productBasket.addProduct(cheese);
        productBasket.addProduct(sausage);
        System.out.println("Попытка добавить продукты в заполненную корзину");
        productBasket.addProduct(cottageCheese);
        System.out.println("\nПечать содержимого корзины с несколькими товарами");
        productBasket.contentsOfTheBasket();
        System.out.println("\nПолучение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины: " + productBasket.basketCost());
        System.out.println("\nПоиск товара, который есть в корзине");
        System.out.println(productBasket.productExists("Хлеб"));
        System.out.println("\nПоиск товара, которого нет в корзине");
        System.out.println(productBasket.productExists("Творог"));
        System.out.println("\nОчистка корзины");
        productBasket.emptyBasket();
        System.out.println("\nПечать содержимого пустой корзины");
        productBasket.contentsOfTheBasket();
        System.out.println("\nПолучение стоимости пустой корзины");
        System.out.println("Стоимость корзины: " + productBasket.basketCost());
        System.out.println("\nПоиск товара в пустой корзине по имени");
        System.out.println(productBasket.productExists("Молоко"));
    }
}
