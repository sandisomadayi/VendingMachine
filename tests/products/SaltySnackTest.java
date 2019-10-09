package products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaltySnackTest {
    @Test
    void shouldDisplayName() {
        SaltySnack softDrink = new SaltySnack("Fanta", "500ml bottle", 6.99);

        assertEquals("Fanta", softDrink.getProductName());
    }
    @Test
    void shouldDisplayDescription() {
        SaltySnack softDrink = new SaltySnack("Fanta", "500ml bottle", 6.99);

        assertEquals("500ml bottle", softDrink.getDescription());
    }
    @Test
    void shouldDisplayPrice() {
        SoftDrink softDrink = new SoftDrink("Fanta", "500ml bottle", 6.99);

        assertEquals(6.99, softDrink.getPrice());
    }
}
