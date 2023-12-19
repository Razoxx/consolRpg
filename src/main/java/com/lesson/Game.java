package com.lesson;


import java.util.Random;
import java.util.Scanner;

class Game extends Character{

    Monster monster;
    Hero hero;
    Scanner scanner;
    Random random;

    public Game(String heroName){
        super();
        scanner = new Scanner(System.in);
        hero = new Hero(heroName, 100,20);
        random = new Random();

    }

}