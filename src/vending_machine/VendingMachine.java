package vending_machine;

import products.*;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine  {
    private int stockLevel = 0;
    private int drinkCount = 0;
    private int saltySnacksCount = 0;
    private int chocolateCount = 0;

    public void buy(Product product) throws ProductNotFoundException {
        if (product instanceof Product) {
            if (product instanceof Chocolate) {
                if (chocolateCount > 0) {
                    chocolateCount--;
                    stockLevel--;
                }
                else {
                    throw new ProductNotFoundException(product);
                }
            }
            else if (product instanceof SoftDrink) {
                if (drinkCount > 0) {
                    drinkCount--;
                    stockLevel--;
                }
                else {
                    throw new ProductNotFoundException(product);
                }
            }
            else if (product instanceof SaltySnack) {
                if (saltySnacksCount > 0) {
                    saltySnacksCount--;
                    stockLevel--;
                }
                else {
                    throw new ProductNotFoundException(product);
                }
            }

        }
        else {
            throw new InvalidProductException();
        }
        System.out.println("stock level " + stockLevel);
    }
    public void addStock(Product product, int newStock) {
        if (product instanceof SoftDrink) {
            drinkCount += newStock;
        }
        else if (product instanceof Chocolate) {
            chocolateCount += newStock;
        }
        else if (product instanceof SaltySnack) {
            saltySnacksCount += newStock;
        }
        stockLevel += newStock;
    }
    public int getProductStock(Product product) {
        if (product instanceof Chocolate) {
            return chocolateCount;
        } else if (product instanceof SoftDrink) {
            return drinkCount;
        }
        return saltySnacksCount;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public static void main(String[] args) throws ProductNotFoundException {
        SoftDrink coke = new SoftDrink("Coke", "350ml coke can", 6.99);
        Chocolate barOne = new Chocolate("Bar one", "250g slab", 7.99);
        SaltySnack simba = new SaltySnack("Simba Chips", "500g bag", 16.99);

        VendingMachine vendingMachine1 = new VendingMachine();
        vendingMachine1.addStock(coke, 4);
        vendingMachine1.addStock(barOne, 3);
        vendingMachine1.addStock(simba, 4);

        vendingMachine1.buy(coke);
        vendingMachine1.buy(coke);
        vendingMachine1.buy(coke);
        vendingMachine1.buy(coke);
        vendingMachine1.buy(simba);
        vendingMachine1.buy(simba);vendingMachine1.buy(simba);
        vendingMachine1.buy(simba);
        vendingMachine1.buy(simba);
//        System.out.println(vendingMachine1.getProductStock(coke));
    }
}
