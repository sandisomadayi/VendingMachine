package products;

public class SoftDrinksOutOfStockException extends ProductNotFoundException {
    public SoftDrinksOutOfStockException(Product product) {
        super(product);
    }
}
