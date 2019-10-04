package products;

public class ChocolatesAllGone extends ProductNotFoundException {
    public ChocolatesAllGone(Product product) {
        super(product);
    }
}
