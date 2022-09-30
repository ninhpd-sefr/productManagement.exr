/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import Entity.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nhat
 */
public class ProductIO {

    public boolean save(List<Product> list) {
        PrintStream ps = null;
        try {
//            ps = new PrintStream(new FileOutputStream("product.dat"));
            ps = new PrintStream("product.txt");
            for (int i = 0, n = list.size(); i < n; i++) {
                Product p = list.get(i);
                ps.println(p.getProductId() + "," + p.getProductName() + "," + p.getUnitPrice() + "," + p.getQuantity() + "," + p.getStatus());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ps.close();
        }
        return false;
    }

    public List<Product> load() {
        List<Product> list = new ArrayList<>();
        File file = new File("product.txt");
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] attributes = line.split(",");
                    String id = attributes[0];
                    String name = attributes[1];
                    float price = Float.parseFloat(attributes[2]);
                    int quantity = Integer.parseInt(attributes[3]);
                    String status = attributes[4];
                    Product p = new Product(id, name, price, quantity, status);
                    list.add(p);
                }
                reader.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
