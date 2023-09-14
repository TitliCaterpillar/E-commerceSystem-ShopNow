package devops;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Product> getItems() {
        return items;
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("E-commerce System Menu:");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    Product product = new Product(productName, productPrice);
                    cart.addProduct(product);
                    System.out.println("Product added to cart.");
                    break;
                case 2:
                    System.out.println("Items in Cart:");
                    for (Product item : cart.getItems()) {
                        System.out.println(item.getName() + " - $" + item.getPrice());
                    }
                    System.out.println("Total: $" + cart.calculateTotal());
                    break;
                case 3:
                    System.out.println("Total amount: $" + cart.calculateTotal());
                    System.out.println("Thank you for shopping! Order is confirmed.");
                    cart = new ShoppingCart(); // Clear the cart after checkout
                    break;
                case 4:
                    System.out.println("Exiting E-commerce System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

