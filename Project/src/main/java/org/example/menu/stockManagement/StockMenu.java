package org.example.menu.stockManagement;

import org.example.menu.Menu;
import org.example.menu.stockManagement.theStockManaging.ChooseStock;
import org.example.methods.otherMethods.ClearConsole;
import java.util.Scanner;

public class StockMenu {
    public static void menu() {
        ClearConsole.clearConsole();
        System.out.println("Выберите:" +
                "\n1) Открыть новый склад" +
                "\n2) Закрыть склад" +
                "\n3) Управление складом" +
                "\n4) Вернуться назад");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                OpenNewStock.openNewStock();
                break;
            case 2:
                CloseStock.closeStock();
                break;
            case 3:
                ChooseStock.chooseStock();
                break;
            case 4:
                Menu.mainMenu();
                break;
        }
    }
}
