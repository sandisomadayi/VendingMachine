package products;

public class Product {
    private String productName;
    private String description;
    private double price;


    public Product(String name, String description, double price) {
        this.productName = name;
        this.description = description;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
}
