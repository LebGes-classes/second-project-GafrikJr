package org.example.menu.sellpointManagement;

import org.example.menu.Menu;
import org.example.menu.sellpointManagement.sellpointManaging.ChooseSellPoint;
import org.example.methods.otherMethods.ClearConsole;
import java.util.Scanner;

public class SellPointMenu {
    public static void menu() {
        ClearConsole.clearConsole();
        System.out.println("Выберите:" +
                "\n1) Открыть новый ПВЗ" +
                "\n2) Закрыть ПВЗ" +
                "\n3) Управление ПВЗ" +
                "\n4) Вернуться назад");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                OpenNewSellPoint.openNewSellPoint();
                break;
            case 2:
                CloseSellPoint.closeSellPoint();
                break;
            case 3:
                ChooseSellPoint.chooseSellPoint();
                break;
            case 4:
                Menu.mainMenu();
                break;
        }
    }
}
