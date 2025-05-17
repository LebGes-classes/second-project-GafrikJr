package org.example.methods.otherMethods;

import java.util.Random;

public class RandomHuman {
    public static String randomHuman() {
        String fullName = "";
        Random random = new Random();
        double randomNumber = random.nextDouble();
        if (randomNumber < 0.5) {
            String[] name = new String[] {"Adel", "Aleksandr", "Alexey", "Anton", "Artem", "Anvar", "Boris", "German", "Daniil", "Dmitriy", "Egor", "Igor", "Konstantin", "Vladislav", "Leonid", "Maxim", "Mikhail", "Nikolay", "Oleg", "Petr", "Ruslan", "Sergey", "Semen", "Timur", "Fedor", "Marat"};
            String[] surname = new String[] {"Antropov", "Aleshin", "Volkov", "Gafarov", "Kotelnikov", "Mardanov", "Khismatullin", "Moskalenko", "Viktorov", "Nosov", "Petrov", "Abramskiy", "Sidorov", "Kirillin", "Evtushenko", "Lobanov", "Lavrov", "Fedorov", "Strel'cov", "Barinov", "Arslanov", "Zubkov", "Zubarev", "Shevtsov", "Kupitman", "Obukhovskiy", "Abdurakhmanov", "Tyushin", "Bezin", "Zainetdinov", "Khairullov", "Yarullin"};
            String[] lastName = new String[] {"Aleksandrovich", "Alexeevich", "Antonovich", "Artemovich", "Anvarovich", "Borisovich", "Germanovich", "Daniilovich", "Egorovich", "Igorevich", "Konstantinovich", "Leonidovich", "Maximovich", "Mikhailovich", "Nikolaevich", "Olegovich", "Petrovich", "Ruslanovich", "Sergeevich", "Semenovich", "Timurovich", "Fedorovich", "Mirzaevich", "Shavkatovich", "Rishatovich", "Rifatovich", "Bakhtiyarovich", "Shagitovich"};
            int nameIndex = random.nextInt(name.length);
            int surnameIndex = random.nextInt(surname.length);
            int lastNameIndex = random.nextInt(lastName.length);
            fullName = surname[surnameIndex] + " " + name[nameIndex] +  " " + lastName[lastNameIndex];
        }
        else {
            String[] name = new String[] {"Aleksandra", "Evgeniya", "Sofia", "Maria", "Marina", "Elizaveta", "Anna", "Anastasia", "Alina", "Alsu", "Dinara", "Asilya", "Galina", "Valentina", "Elena", "Polina", "Arina", "Ekaterina", "Svetlana", "Natalya"};
            String[] surname = new String[] {"Antropova", "Aleshina", "Volkova", "Gafarova", "Kotelnikova", "Mardanova", "Khismatullina", "Moskalenko", "Viktorova", "Nosova", "Petrova", "Abramskaya", "Sidorova", "Kirillina", "Evtushenko", "Lobanova", "Lavrova", "Fedorova", "Strel'cova", "Barinova", "Arslanova", "Zubkova", "Zubareva", "Shevtsova", "Kupitman", "Obukhovskaya", "Gaifullina",  "Chekurova", "Mikheeva", "Ryasina", "Popova", "Korneeva", "Zubkova"};
            String[] lastname = new String[] {"Aleksandrovna", "Alexeevna", "Antonovna", "Artemovna", "Anvarovna", "Borisovna", "Germanovna", "Daniilovna", "Egorovna", "Igorevna", "Konstantinovna", "Leonidovna", "Maximovna", "Mikhailovna", "Nikolaevna", "Olegovna", "Petrovna", "Ruslanovna", "Sergeevna", "Semenovna", "Timurovna", "Fedorovna", "Maratovna"};
            int nameIndex = random.nextInt(name.length);
            int surnameIndex = random.nextInt(surname.length);
            int lastNameIndex = random.nextInt(lastname.length);
            fullName = surname[surnameIndex] + " " + name[nameIndex] +  " " + lastname[lastNameIndex];
        }

        return fullName;
    }
}
