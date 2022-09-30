package UI;

import Controller.ProductManager;
import Entity.Product;
import IO.ProductIO;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nhat
 */
public class ProductConsole {

    private ProductManager pm;
    private ProductIO io;
    private Scanner sc;

    public ProductConsole() {
        this.sc = new Scanner(System.in);
        this.io = new ProductIO();
        this.pm = new ProductManager(io.load());
    }

    private int menu() {
        System.out.println("~~~###---PRODUCT MENU---###~~~");
        System.out.println("1. Add product");
        System.out.println("2. Show all product");
        System.out.println("3. Remove product by ID");
        System.out.println("4. Update product by ID");
        System.out.println("5. Check exist product");
        System.out.println("6. Search product by name");
        System.out.println("7. Save file");
        System.out.println("0. Exit");
        System.out.println("~~~###------------------###~~~");
        System.out.println("Select your choice: ");
        int choice = readInt(0, 7);
        return choice;
    }

    public void start() {
        boolean cont = true;
        while (cont) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduct();
                    utils.utils.askToback();
                    break;
                case 2:
                    showAll();
                    utils.utils.askToback();
                    break;
                case 3:
                    removeProduct();
                    utils.utils.askToback();
                    break;
                case 4:
                    updateProduct();
                    utils.utils.askToback();
                    break;
                case 5:
                    checkProduct();
                    utils.utils.askToback();
                    break;
                case 6:
                    searchProduct();
                    utils.utils.askToback();
                    break;
                case 7:
                    saveFile();
                    utils.utils.askToback();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private int readInt(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void addProduct() {
        String id = utils.utils.inputValue("Enter product ID: ");
        String name = utils.utils.inputValueName("Enter product name:", this.pm.getListOfProduct());
        float price = utils.utils.inputValuePrice("Enter product price", 0, 10000);
        int quantity = utils.utils.inputValueQuantity("Enter product quantity", 0, 1000);
        String status = utils.utils.inputValueStatus("Enter product status:");
        Product p = new Product(id, name, price, quantity, status);
        this.pm.addProduct(p);
    }

    private void showAll() {
        Collections.sort(this.pm.getListOfProduct());
        System.out.println("--All product--");
        System.out.println("ID\tName\t\tPrice\t\tQuantity\tStatus");
        for (int i = 0; i < this.pm.count(); i++) {
            Product p = this.pm.getProduct(i);
            p.display();
        }
    }

    private void removeProduct() {
        System.out.println("which ID Product is remove ?");
        String id = sc.nextLine();
        boolean result = this.pm.removeProduct(id);
        if (result) {
            System.out.println("Product was removed");
        } else {
            System.out.println("Product does not exist");
        }
    }

    private void updateProduct() {
        System.out.println("which ID Product is update ?");
        String id = sc.nextLine();
        boolean result = this.pm.updateProduct(id);
        if (result) {
            System.out.println("Product was updated");
        } else {
            System.out.println("Product does not exist");
        }
    }

    private void searchProduct() {
        String name = utils.utils.inputValueName("Input name to check: ");
        int check = 0;
        System.out.println("---Results for key search (" + name + ")----");
        System.out.println("ID\tName\t\tPrice\t\tQuantity\tStatus");
        for (int i = 0; i < this.pm.count(); i++) {
            Product p = this.pm.getProduct(i);
            if (p.getProductName().contains(name.toLowerCase())) {
                p.display();
                check = 1;
            }
        }

        if (check == 0) {
            System.out.println("Have no any Product");
        }
    }

    private void checkProduct() {
        String name = utils.utils.inputValueName("Input name to check: ");
        int check = 0;
        for (int i = 0; i < this.pm.count(); i++) {
            Product p = this.pm.getProduct(i);
            if (this.pm.getProduct(i).getProductName().equals(name)) {
                check = 1;
                break;
            }
        }
        if (check == 1) {
            System.out.println("Exist Product");
        } else {
            System.out.println("No Product Found!");
        }
    }

    private void saveFile() {
        this.io.save(pm.getListOfProduct());
        System.out.println("Product was saved");
    }

}
