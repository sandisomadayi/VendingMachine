package vending_machine;

import product_exceptions.*;
import products.*;

public class VendingMachine  {
    private int stockLevel = 0;
    private int drinkCount = 0;
    private int saltySnackCount = 0;
    private int chocolateCount = 0;

    public void buy(Product product) throws ProductNotFoundException, InvalidProductException {
        if (product != null) {
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
                if (saltySnackCount > 0) {
                    saltySnackCount--;
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
        if (product instanceof Product) {
            if (product instanceof SoftDrink) {
                drinkCount += newStock;
            } else if (product instanceof Chocolate) {
                chocolateCount += newStock;
            } else if (product instanceof SaltySnack) {
                saltySnackCount += newStock;
            }
            stockLevel += newStock;
        }
        else {
            throw new InvalidProductException();
        }
    }
    public String getStockLevel(Product product) {
        if (product instanceof Chocolate) {
            return product.getProductName() + " left: " + chocolateCount;
        } else if (product instanceof SoftDrink) {
            return product.getProductName() + " left: " + drinkCount;
        }
        return product.getProductName() + " left: " + saltySnackCount;
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



            vendingMachine1.addStock(coke, 1);
            vendingMachine1.addStock(barOne, 1);
            vendingMachine1.addStock(simba, 1);

            System.out.println(vendingMachine2.getStockLevel());

            System.out.println(vendingMachine1.getStockLevel());
            vendingMachine1.buy(coke);
            System.out.println(vendingMachine1.getStockLevel());
            System.out.println(vendingMachine1.getStockLevel(coke));

        } catch (SaltyCracksAllEatenException sa) {
            System.out.println("No more salty snacks available");
        } catch (SoftDrinksOutOfStockException so) {
            System.out.println("Out of soft drinks");
        } catch (ChocolatesAllGone ch) {
            System.out.println("No more chocolates available");
        } catch (ProductNotFoundException pr) {
            System.out.println("Product you are looking for is not available");
        }
        VendingMachine vendingMachine = new VendingMachine();
        System.out.println(vendingMachine);
    }
}
