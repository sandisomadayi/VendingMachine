package vending_machine;

import product_exceptions.*;
import products.*;

public class MaxiVendingMachine extends VendingMachine {
    private int saltySnackCount = 0;
    private int chocolateCount = 0;
    private int softDrinkCount = 0;

    @Override
    public void buy(Product product) throws InvalidProductException, ProductNotFoundException {
        if (product != null) {
            if (product instanceof Chocolate) {
                if (chocolateCount > 0) {
                    chocolateCount--;
                }
                else {
                    throw new ChocolatesAllGone(product);
                }
            }
            else if (product instanceof SoftDrink) {
                if (softDrinkCount > 0) {
                    softDrinkCount--;
                }
                else {
                    throw new SoftDrinksOutOfStockException(product);
                }
            }
            else if (product instanceof SaltySnack) {
                if (saltySnackCount > 0) {
                    saltySnackCount--;
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
    public void buy(SaltySnack saltySnack) throws SaltyCracksAllEatenException {
            if (saltySnackCount > 0) {
                saltySnackCount--;
            }
            else {
                throw new SaltyCracksAllEatenException(saltySnack);
            }
    }
    public void buy(Chocolate chocolate) throws ChocolatesAllGone {
            if (chocolateCount > 0) {
                chocolateCount--;
            }else {
                throw new ChocolatesAllGone(chocolate);
            }
    }

    public void buy(SoftDrink softDrink) throws SoftDrinksOutOfStockException {
            if (softDrinkCount > 0) {
                softDrinkCount--;
            }
            else {
                throw new SoftDrinksOutOfStockException(softDrink);
            }
    }

    @Override
    public void addStock(Product product, int newStock) throws InvalidProductException{
        if (product != null) {
            if (product instanceof SoftDrink) {
                softDrinkCount += newStock;
            } else if (product instanceof Chocolate) {
                chocolateCount += newStock;
            } else if (product instanceof SaltySnack) {
                saltySnackCount += newStock;
            }
        }
        else {
            throw new InvalidProductException();
        }
    }
    public void addStock(SaltySnack saltySnack, int newStock) {
        saltySnackCount += newStock;
    }
    public void addStock(SoftDrink softDrink, int newStock) {
        softDrinkCount += newStock;
    }
    public void addStock(Chocolate chocolate, int newStock) {
        chocolateCount += newStock;
    }

    public String getStockLevel(Product product) {
        if (product instanceof Chocolate) {
            return product.getProductName() + " left: " + chocolateCount;
        } else if (product instanceof SoftDrink) {
            return product.getProductName() + " left: " + softDrinkCount;
        }
        return product.getProductName() + " left: " + saltySnackCount;
    }

    @Override
    public int getStockLevel() {
        return chocolateCount+softDrinkCount+saltySnackCount;
    }
}
