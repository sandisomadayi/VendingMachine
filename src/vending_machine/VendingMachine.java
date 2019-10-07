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
                    throw new ChocolatesAllGone(product);
                }
            }
            else if (product instanceof SoftDrink) {
                if (drinkCount > 0) {
                    drinkCount--;
                    stockLevel--;
                }
                else {
                    throw new SoftDrinksOutOfStockException(product);
                }
            }
            else if (product instanceof SaltySnack) {
                if (saltySnacksCount > 0) {
                    saltySnacksCount--;
                    stockLevel--;
                }
                else {
                    throw new SaltyCracksAllEatenException(product);
                }
            }

        }
        else {
            throw new InvalidProductException();
        }
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
    public String getProductStock(Product product) {
        if (product instanceof Chocolate) {
            return product.getProductName() + " left: " + chocolateCount;
        } else if (product instanceof SoftDrink) {
            return product.getProductName() + " left: " + drinkCount;
        }
        return product.getProductName() + " left: " + saltySnacksCount;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public static void main(String[] args) {
        try {
            SoftDrink coke = new SoftDrink("Coke", "350ml coke can", 6.99);
            Chocolate barOne = new Chocolate("Bar one", "250g slab", 7.99);
            SaltySnack simba = new SaltySnack("Simba Chips", "500g bag", 16.99);

            VendingMachine vendingMachine1 = new VendingMachine();
            VendingMachine vendingMachine2 =  new VendingMachine();

            vendingMachine1.addStock(coke, 4);
            vendingMachine1.addStock(barOne, 3);
            vendingMachine1.addStock(simba, 4);

            System.out.println(vendingMachine2.getStockLevel());

            System.out.println(vendingMachine1.getStockLevel());
            vendingMachine1.buy(coke);
            System.out.println(vendingMachine1.getStockLevel());
            System.out.println(vendingMachine1.getProductStock(coke));
        } catch (SaltyCracksAllEatenException sa) {
            sa.printStackTrace();
        } catch (SoftDrinksOutOfStockException so) {
            so.printStackTrace();
        } catch (ChocolatesAllGone ch) {
            ch.printStackTrace();
        } catch (ProductNotFoundException pr) {
            pr.printStackTrace();
        }
//        System.out.println(vendingMachine1.getProductStock(coke));
    }
}
