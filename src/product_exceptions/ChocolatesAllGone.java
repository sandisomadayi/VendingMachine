package product_exceptions;

import products.Product;

public class ChocolatesAllGone extends ProductNotFoundException {
    public ChocolatesAllGone(Product product) {
        super(product);
    }
}
