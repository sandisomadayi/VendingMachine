package product_exceptions;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException() {
        System.out.println("Product entered is not available.");
    }
}
