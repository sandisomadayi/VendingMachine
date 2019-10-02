package products;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Product product) {
        System.out.println(product.getProductName() + " is out of stock");
    }
}
