package products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsTest {
    @Test
    void shouldDisplayProductName() {
        Product product = new Product("coke", "330ml can", 6.99);
        assertEquals("coke", product.getProductName());
    }
}
