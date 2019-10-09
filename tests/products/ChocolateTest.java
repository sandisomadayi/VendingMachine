package products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChocolateTest {
    @Test
    void shouldDisplayName() {
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        assertEquals("aero", aero.getProductName());
    }

    @Test
    void shouldDisplayDescription() {
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        assertEquals("200g slab", aero.getDescription());
    }

    @Test
    void shouldDisplayPrice() {
        Product aero = new Chocolate("aero", "200g slab", 23.99);

        assertEquals(23.99, aero.getPrice());
    }
}
