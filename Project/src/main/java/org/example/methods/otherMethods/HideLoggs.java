package org.example.methods.otherMethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HideLoggs {
    public static void hideLoggs() {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);  // Только ошибки
        Logger.getLogger("org.hibernate.SQL").setLevel(Level.OFF); // SQL-запросы
    }
}
