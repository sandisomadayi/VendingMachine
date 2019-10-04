package products;

public class SaltyCracksAllEatenException extends ProductNotFoundException {
    public SaltyCracksAllEatenException(Product product) {
        super(product);
    }
}
