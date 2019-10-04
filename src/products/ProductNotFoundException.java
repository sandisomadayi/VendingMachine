package products;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Product product) {
        if (product.getProductName().toLowerCase().endsWith("s")) {
            System.out.println(product.getProductName() + " are out of stock");
        }
        else {
            System.out.println(product.getProductName() + " is out of stock");
        }
    }
}
