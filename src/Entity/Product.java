package Entity;

/**
 *
 * @author Nhat
 */
public class Product implements Comparable<Product>{

    private String productId;
    private String productName;
    private float unitPrice;
    private int quantity;
    private String status;

    public Product(String productId, String productName, float unitPrice, int quantity, String status) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void display() {
        System.out.println(this.getProductId() + "\t" + this.getProductName() + "\t" + this.getUnitPrice() + "\t\t" + this.getQuantity() + "\t\t" + this.getStatus());

    }
    
    @Override
    public int compareTo(Product o) {
        if (this.quantity == o.quantity) {
            return (int) (this.unitPrice - o.unitPrice);
        }
        return (this.quantity - o.quantity) * -1;
    }

}
