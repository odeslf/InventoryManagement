import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public boolean addProduct(String productName, double price, int quantity) {
        Product existingProduct = findProduct(productName);
        if (existingProduct == null) {
            products.add(new Product(productName, price, quantity));
            return true;
        }
        return false;
    }

    public boolean removeProduct(String productName) {
        Product productToExclude = findProduct(productName);
        if (productToExclude != null) {
            products.remove(productToExclude);
            return true;
        }
        return false;
    }

    public boolean updateProductQuantity(String productName, int newQuantity){
        Product productToUpdate = findProduct(productName);
        if (productToUpdate != null) {
            productToUpdate.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    public Product findProduct(String productName){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().equalsIgnoreCase(productName)){
                return products.get(i);
            }
        }
        return null;
    }

    public void listProducts() {

        if(products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Products in the inventory: ");
            System.out.println("-".repeat(30));
            for (Product p : products) {
                System.out.println("Name: " + p.getName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getQuantity());
                System.out.println("-".repeat(30));
            }
        }
    }
}
