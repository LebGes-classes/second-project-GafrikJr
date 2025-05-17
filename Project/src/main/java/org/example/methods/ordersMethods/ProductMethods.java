package org.example.methods.ordersMethods;

import org.example.model.orders.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMethods {
    private static final File PRODUCT_TXT = new File("C://Users/Тимур/Documents/GitHub/MarketPlaceProject/files/Products.txt");

    public static Product getProductById(int _id) {
        Product product = null;
        String[] columns = new String[4];
        try {
            Scanner scanner = new Scanner(PRODUCT_TXT);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                columns = scanner.nextLine().split("  ");
                if (Integer.parseInt(columns[0]) == _id) {
                    product = new Product(
                            Integer.parseInt(columns[0]),
                            columns[1],
                            Integer.parseInt(columns[2]),
                            Integer.parseInt(columns[3])
                    );
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        try (Scanner scanner = new Scanner(PRODUCT_TXT);) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] columns = new String[4];
                columns = scanner.nextLine().split("  ");
                Product product = new Product(
                        Integer.parseInt(columns[0]),
                        columns[1],
                        Integer.parseInt(columns[2]),
                        Integer.parseInt(columns[3])
                );
                allProducts.add(product);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    public static void printAllProducts() {
        List<Product> allProducts = getAllProducts();
        for (Product product : allProducts) {
            product.printInfo();
        }
    }
}
