package vending_machine;

import org.junit.jupiter.api.Test;
import product_exceptions.ChocolatesAllGone;
import product_exceptions.ProductNotFoundException;
import product_exceptions.SaltyCracksAllEatenException;
import product_exceptions.SoftDrinksOutOfStockException;
import products.Chocolate;
import products.Product;
import products.SaltySnack;
import products.SoftDrink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrow;

public class MaxiVendingMachineTest {

    @Test
    void shouldDisplayTotalStock() {
        Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
        Product lays = new SaltySnack("lays", "500g bag", 16.99);
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();
        try {
            maxiVendingMachine.addStock(fanta, 4);
            maxiVendingMachine.addStock(lays, 4);
            maxiVendingMachine.addStock(aero, 4);
            maxiVendingMachine.buy(lays);
        } catch (SoftDrinksOutOfStockException so) {
            so.printStackTrace();
        } catch (SaltyCracksAllEatenException sa) {
            sa.printStackTrace();
        } catch (ChocolatesAllGone ch) {
            ch.printStackTrace();
        } catch (ProductNotFoundException pr) {
            pr.printStackTrace();
        }
        assertEquals(11, maxiVendingMachine.getStockLevel());
    }
    @Test
    void shouldDisplaySoftDrinkStock() {

            Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
            Product lays = new SaltySnack("lays", "500g bag", 16.99);
            Product aero = new Chocolate("aero", "200g slab", 23.99);

            MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();

        try {
            maxiVendingMachine.addStock(fanta, 4);
            maxiVendingMachine.addStock(lays, 4);
            maxiVendingMachine.addStock(aero, 4);
            maxiVendingMachine.buy(aero);
        } catch (SoftDrinksOutOfStockException so) {
            so.printStackTrace();
        } catch (SaltyCracksAllEatenException sa) {
            sa.printStackTrace();
        } catch (ChocolatesAllGone ch) {
            ch.printStackTrace();
        } catch (ProductNotFoundException pr) {
            pr.printStackTrace();
        }

        assertEquals("fanta remaining: 4", maxiVendingMachine.getStockLevel(fanta));
    }
    @Test
    void shouldDisplaySaltySnackStock() {
        Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
        Product lays = new SaltySnack("lays", "500g bag", 16.99);
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();
        try {
            maxiVendingMachine.addStock(fanta, 4);
            maxiVendingMachine.addStock(lays, 4);
            maxiVendingMachine.addStock(aero, 4);
            maxiVendingMachine.buy(aero);
            maxiVendingMachine.buy(aero);
            maxiVendingMachine.buy(aero);
        } catch (SoftDrinksOutOfStockException so) {
            so.printStackTrace();
        } catch (SaltyCracksAllEatenException sa) {
            sa.printStackTrace();
        } catch (ChocolatesAllGone ch) {
            ch.printStackTrace();
        } catch (ProductNotFoundException pr) {
            pr.printStackTrace();
        }

        assertEquals("lays remaining: 4", maxiVendingMachine.getStockLevel(lays));
    }
    @Test
    void shouldDisplayChocolateStock() {
        Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
        Product lays = new SaltySnack("lays", "500g bag", 16.99);
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();

        try {
            maxiVendingMachine.addStock(fanta, 4);
            maxiVendingMachine.addStock(lays, 4);
            maxiVendingMachine.addStock(aero, 4);
            maxiVendingMachine.buy(aero);
            maxiVendingMachine.buy(aero);
            maxiVendingMachine.buy(aero);
        } catch (SoftDrinksOutOfStockException so) {
            so.printStackTrace();
        } catch (SaltyCracksAllEatenException sa) {
            sa.printStackTrace();
        } catch (ChocolatesAllGone ch) {
            ch.printStackTrace();
        } catch (ProductNotFoundException pr) {
            pr.printStackTrace();
        }

        assertEquals("aero remaining: 1", maxiVendingMachine.getStockLevel(aero));
    }
    @Test
    void shouldThrowSaltySnackException() {
        MaxiVendingMachine machine1 = new MaxiVendingMachine ();
        SaltySnack lays = new SaltySnack("lays", "500g bag", 16.99);
        
        assertThrow(SaltyCracksAllEatenException.class, () -> machine1.buy(lays));
    }
}
