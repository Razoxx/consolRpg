package com.lesson;


import java.util.Scanner;

public class RpgGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя героя ");
        String heroName = scanner.next();

        Game game = new Game(heroName);
        game.start();
        game.shop();

    }
}