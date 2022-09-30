package Controller;

import Entity.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Nhat
 */
public class ProductManager {

    private List<Product> listOfProduct;

    public ProductManager() {
        this.listOfProduct = new ArrayList<>();
    }

    public ProductManager(List<Product> listOfProduct) {
        this.listOfProduct = listOfProduct;
    }

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }

    public int addProduct(Product p) {
        this.listOfProduct.add(p);
        System.out.println("Add product to success");
        return count();
    }

    public int count() {
        return this.listOfProduct.size();
    }

    public Product getProduct(int index) {
        if (index < 0 || index >= count()) {
            return null;
        }
        return this.listOfProduct.get(index);
    }

    public boolean removeProduct(String id) {
        int index = -1;
        for (int i = 0, n = count(); i < n; i++) {
            if (this.listOfProduct.get(i).getProductId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.listOfProduct.remove(index);
            return true;
        }
        return false;
    }

    public boolean updateProduct(String id) {
        int index = -1;
        for (int i = 0, n = count(); i < n; i++) {
            if (this.listOfProduct.get(i).getProductId().equals(id)) {
                this.listOfProduct.get(i).setProductName(utils.utils.updateValueName("Enter product name:", this.listOfProduct.get(i).getProductName(), listOfProduct));
                this.listOfProduct.get(i).setUnitPrice(utils.utils.updateValuePrice("Enter product price", 0, 10000, this.listOfProduct.get(i).getUnitPrice()));
                this.listOfProduct.get(i).setQuantity(utils.utils.updateValueQuantity("Enter product quantity", 0, 1000, this.listOfProduct.get(i).getQuantity()));
                this.listOfProduct.get(i).setStatus(utils.utils.updateValueStatus("Enter product status:", this.listOfProduct.get(i).getStatus()));
                return true;
            }
        }

        return false;
    }

}
