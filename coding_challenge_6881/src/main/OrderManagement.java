package main;
import dao.*;
import entity.Product;
import entity.User;
import entity.Orders1;

import java.util.Collection;
import java.util.Scanner;

public class OrderManagement {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductServiceImp1 productService = new ProductServiceImp1(scanner);
        ProductServiceImp2 userService = new ProductServiceImp2();
        OrderServiceImp1 orderService = new OrderServiceImp1();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create User");
            System.out.println("2. Create Product");
            System.out.println("3. Get All Products");
            System.out.println("4. cancel product");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createUser(userService);
                    break;
                case 2:
                    createProduct(productService);
                    break;
                case 3:
                    getAllProducts(productService);
                    break;
                case 4:
                	  deleteProduct(productService);
                      break;
                	
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void deleteProduct(ProductServiceImp1 productService) {
        System.out.println("Enter Product ID to delete:");
        int productId = scanner.nextInt();

        if (productService.deleteProduct(productId)) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found or deletion failed. Enter a valid Product ID.");
        }
    }
    private static void createUser(ProductServiceImp2 userService) {
        System.out.println("Enter User ID:");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.println("Enter User Name:");
        String userName = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        User newUser = new User(userId, userName, password, "User");
        if (userService.createUser(newUser)) {
            System.out.println("User created successfully.");
        } else {
            System.out.println("User ID already exists. Enter a new User ID.");
        }
    }

    private static void createProduct(ProductServiceImp1 productService) {
        System.out.println("Enter Product ID:");
        int productId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.println("Enter Product Name:");
        String productName = scanner.nextLine();
        System.out.println("Enter Description:");
        String description = scanner.nextLine();
        System.out.println("Enter Price:");
        double price = scanner.nextDouble();
        System.out.println("Enter Quantity in Stock:");
        int quantityInStock = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.println("Enter Type:");
        String type = scanner.nextLine();

        Product newProduct = new Product(productId, productName, description, price, quantityInStock, type);
        if (productService.createProduct(newProduct)) {
            System.out.println("Product created successfully.");
        } else {
            System.out.println("Product ID already exists. Enter a new Product ID.");
        }
    }

    private static void getAllProducts(ProductServiceImp1 productService) {
        System.out.println("All Products:");
        productService.getAllProducts().forEach(System.out::println);
    }

    private static void getOrdersByUser(OrderServiceImp1 orderService) {
        System.out.println("Enter User ID to get orders:");
        int userId = scanner.nextInt();

        Collection<Orders1> orders = orderService.getOrdersByUser(userId);

        if (orders.isEmpty()) {
            System.out.println("No orders found for the given User ID.");
        } else {
            System.out.println("Orders for User ID " + userId + ":");
            orders.forEach(System.out::println);
        }
    }
}




