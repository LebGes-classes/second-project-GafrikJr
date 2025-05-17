package org.example;

import org.example.menu.Menu;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.otherMethods.HideLoggs;

public class Main {
    public static void main(String[] args) {
        ClearConsole.clearConsole();
        HideLoggs.hideLoggs();
        Menu.mainMenu();
    }
}
