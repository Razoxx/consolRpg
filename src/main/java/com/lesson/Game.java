package com.lesson;

import java.util.Random;
import java.util.Scanner;

class Game {
    Scanner scanner;
    Random random;
     Hero hero;
     Monster monster;

    public Game(String heroName) {
        scanner = new Scanner(System.in);
        random = new Random();
        hero = new Hero(heroName, 150, 20);
        monster = new Monster("Орк", 177, 19);
    }
}