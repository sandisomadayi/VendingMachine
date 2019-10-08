package product_exceptions;

import products.Product;

public class SoftDrinksOutOfStockException extends ProductNotFoundException {
    public SoftDrinksOutOfStockException(Product product) {
        super(product);
    }
}
