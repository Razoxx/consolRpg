package com.lesson;

import java.util.Random;
import java.util.Scanner;

public class RpgGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите имя героя ");
        String heroName = scanner.next();

        Hero hero = new Hero(heroName, 15, 5);
        Monster monster = new Monster("Орк", 15, 3);

        System.out.println("Старт игры");
        System.out.println("Герой " + hero.getName() + " вошел в лес и увидел " + monster.getName() +
                ". Игра началась");

        while (true) {
            System.out.println("Режим битвы");
            System.out.println("Выбери действие: 1.Атака 2.Защита 3.Пропуск хода");
            int command = scanner.nextInt();

            if (command == 1) {
                hero.performAttack(monster, random);
            } else if (command == 2) {
                hero.defend();
            } else {
                System.out.println("Пропуск хода ");
            }

            System.out.println("У героя " + hero.getName() + " сейчас " + hero.getHealth() + " единиц здоровья ");
            System.out.println("Ход монстра ");
            int monsterCommand = random.nextInt(2);

            if (monsterCommand == 0) {
                monster.performAttack(hero);
            } else {
                monster.rest();
            }

            if (hero.getHealth() <= 0) {
                System.out.println("Монстр победил");
                break;
            }

            if (monster.getHealth() <= 0) {
                System.out.println("Герой победил");
                break;
            }
        }

        System.out.println("Игра окончена");
    }
}