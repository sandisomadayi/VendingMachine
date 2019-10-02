package vending_machine;

import products.Product;
import products.ProductNotFoundException;

public class VendingMachine  {
    private static int stockLevel;
    public static void buy(Product product) throws ProductNotFoundException {
        stockLevel++;
    }
    public static void addStock(Product product, int newStock) {
        stockLevel += newStock;
    }
    public int geStock() {
        return stockLevel;
    }

    public static void overrideStatic() {
        System.out.println("vending machine");
    }
}
