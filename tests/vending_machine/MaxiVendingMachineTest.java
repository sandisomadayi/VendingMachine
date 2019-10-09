package vending_machine;

import org.junit.jupiter.api.Test;
import products.Chocolate;
import products.Product;
import products.SaltySnack;
import products.SoftDrink;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxiVendingMachineTest {

    @Test
    void shouldDisplayTotalStock() {
        Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
        Product simba = new SaltySnack("lays", "500g bag", 16.99);
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();
        maxiVendingMachine.addStock(fanta, 4);
        maxiVendingMachine.addStock(simba, 4);
        maxiVendingMachine.addStock(aero, 4);

        assertEquals(12, maxiVendingMachine.getStockLevel());
    }
    @Test
    void shouldDisplaySoftDrinkStock() {
        Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
        Product simba = new SaltySnack("lays", "500g bag", 16.99);
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();
        maxiVendingMachine.addStock(fanta, 4);
        maxiVendingMachine.addStock(simba, 4);
        maxiVendingMachine.addStock(aero, 4);

        assertEquals("fanta remaining: 4", maxiVendingMachine.getStockLevel(fanta));
    }
    @Test
    void shouldDisplaySaltySnackStock() {
        Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
        Product lays = new SaltySnack("lays", "500g bag", 16.99);
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();
        maxiVendingMachine.addStock(fanta, 4);
        maxiVendingMachine.addStock(lays, 4);
        maxiVendingMachine.addStock(aero, 4);

        assertEquals("lays remaining: 4", maxiVendingMachine.getStockLevel(lays));
    }
    @Test
    void shouldDisplayChocolateStock() {
        Product fanta = new SoftDrink("fanta", "500ml bottle", 6.99);
        Product simba = new SaltySnack("lays", "500g bag", 16.99);
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();
        maxiVendingMachine.addStock(fanta, 4);
        maxiVendingMachine.addStock(simba, 4);
        maxiVendingMachine.addStock(aero, 4);

        assertEquals("aero remaining: 4", maxiVendingMachine.getStockLevel(aero));
    }
}
