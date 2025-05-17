package org.example.methods.ordersMethods;

import org.example.model.users.Buyer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuyerMethods {
    private static final File BUYER_TXT = new File("C://Users/Тимур/Documents/GitHub/MarketPlaceProject/files/Buyers.txt");

    public static Buyer getBuyerById(int id) {
        Buyer buyer = null;
        try {
            Scanner scanner = new Scanner(BUYER_TXT);
            String[] columns = new String[2];
            boolean isFound = false;
            scanner.nextLine(); // чтобы пропустить первую строку с названиями столбцов
            while (scanner.hasNext() && !isFound) {
                columns = scanner.nextLine().split("  ");
                if (Integer.parseInt(columns[0]) == id) {
                    buyer = new Buyer(Integer.parseInt(columns[0]), columns[1]);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return buyer;
    }
}
