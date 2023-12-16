package entity;

public class Clothing extends Product {
    private String size;
    private String color;

    // Default constructor
    public Clothing() {
        // Call the default constructor of the superclass (Product)
        super();
    }

    // Parameterized constructor
    public Clothing(int productId, String productName, String description, double price,
                    int quantityInStock, String type, String size, String color) {
        // Call the parameterized constructor of the superclass (Product)
        super(productId, productName, description, price, quantityInStock, type);
        this.size = size;
        this.color = color;
    }

    // Getters and setters specific to Clothing
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString method for better representation
    @Override
    public String toString() {
        return "Clothing{" +
                "productId=" + getProductId() +
                ", productName='" + getProductName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                ", quantityInStock=" + getQuantityInStock() +
                ", type='" + getType() + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
