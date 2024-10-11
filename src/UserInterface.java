import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private Inventory inventory;
    private Scanner scanner;

    public UserInterface() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("Choose a option: ");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product");
            System.out.println("3. Update product quantity");
            System.out.println("4. Product list");
            System.out.println("5. Quit");

            option = scanner.nextInt();
            switch (option) {
                case 1 -> addProductUI();
                case 2 -> removeProductUI();
                case 3 -> updateProductQuantityUI();
                case 4 -> listProductsUI();
                case 5 -> System.out.println("Quiting...");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (option != 5);
    }

    private void addProductUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the product name: ");
        String productName = scanner.nextLine();

        System.out.print("Type the product price: ");
        double price = scanner.nextDouble();

        System.out.print("Type the quantity: ");
        int quantity = scanner.nextInt();

        boolean success = inventory.addProduct(productName, price, quantity);
        if (success) {
            System.out.println("Product added successfully: " + productName);
        } else {
            System.out.println("The product " + productName + " it's already in the inventory.");
        }
    }

    private void removeProductUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the product name to remove: ");
        String productName = scanner.nextLine();

        boolean success = inventory.removeProduct(productName);
        if (success) {
            System.out.println("Product removed successfully: " + productName);
        } else {
            System.out.println("The product " + productName + " don't exist in the inventory");
        }
    }

    private void updateProductQuantityUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the product name to update the quantity: ");
        String productName = scanner.nextLine();

        int quantity = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Type a new quantity: ");
            try {
                quantity = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please, insert a valid number for quantity");
                scanner.next();
            }
        }

        boolean success = inventory.updateProductQuantity(productName, quantity);
        if (success) {
            System.out.println("The product " + productName + " has been successfully updated");
        } else {
            System.out.println("Wrong, try again.");
        }
    }

    private void listProductsUI() {
        inventory.listProducts();
    }

}
