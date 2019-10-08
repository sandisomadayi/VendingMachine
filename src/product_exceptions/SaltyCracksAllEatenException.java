package product_exceptions;

import products.Product;

public class SaltyCracksAllEatenException extends ProductNotFoundException {
    public SaltyCracksAllEatenException(Product product) {
        super(product);
    }
}
