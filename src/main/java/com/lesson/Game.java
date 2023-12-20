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
        hero = new Hero();
        monster = new Monster();
    }

}