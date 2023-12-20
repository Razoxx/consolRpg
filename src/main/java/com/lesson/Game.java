package com.lesson;

import java.util.Random;
import java.util.Scanner;


class Game {
    private Hero hero;
    private Monster monster;
    private Scanner scanner;
    private Random random;

    public Game(String heroName) {
        scanner = new Scanner(System.in);
        random = new Random();
        hero = new Hero(heroName, 150, 20);
        monster = new Monster("Монстр(а)", 160, 20);
    }

    public void start() {
        System.out.println("//////________\\\\\\\\\\\\\\");
                System.out.println("     Старт игры");
        System.out.println("//////________\\\\\\\\\\\\\\");
        System.out.println("Герой " + hero.name + " вошел в лес и увидел " + monster.name + ". Игра началась");

        while (hero.isAlive() && monster.isAlive()) {
            battlePhase(hero, monster);
            if (monster.isAlive()) {
                battlePhase(monster, hero);
            }
        }

        printResult();
    }

    private void battlePhase(Character attacker, Character target) {
        System.out.println("Режим битвы");
        System.out.println("Выбери действие: 1.Атака 2.Защита 3.Уклонение");

        int command = scanner.nextInt();
        if (command == 1) {
            attacker.attack(target);
            if (random.nextInt(100) < 10) {
                System.out.println("Герой смог нанести дополнительный урон!");
                attacker.attack(target);
            }
        } else if (command == 2) {
            attacker.rest();
        } else {
            System.out.println("Пропуск хода ");
        }

        System.out.println("У " + target.name + " сейчас " + target.health + " единиц здоровья.");
    }

    private void printResult() {
        if (hero.isAlive()) {
            System.out.println("Герой " + hero.name + " победил!");
        } else {
            System.out.println("Монстр " + monster.name + " победил!");
        }

        System.out.println("Игра окончена");
    }
}