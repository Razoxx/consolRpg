package com.lesson;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class Game {
    private Hero hero;
    private Monster monster;
    private Scanner scanner;
    private Random random;
    Shop shop;
    

    public Game(String heroName) {
        scanner = new Scanner(System.in);
        random = new Random();
        shop = new Shop();
        hero = new Hero(heroName, 150, 25);
        monster = new Monster("Орк", 150, 20, 1, 50);
    }

    public void start() {
        System.out.println("\nСтарт игры\n");
        System.out.printf("Герой %s вошел в лес и увидел %s. Игра началась", hero.getName(), monster.getName());

        while (hero.isAlive() && monster.isAlive()) {
            battlePhase(hero, monster);
            if (monster.isAlive()) {
                battlePhase(monster, hero);
            }
        }

        printResult();
    }


    private void battlePhase(Character attacker, Character target) {
        System.out.println("\nРежим битвы\n");
        System.out.println("Выбери действие: 1.Атака 2.Защита 3.Уклонение 4.Магазин");

        int command = scanner.nextInt();
        if (command == 1) {
            attacker.attack(target);
            if (random.nextInt(100) < 10) {
                System.out.println("Герой смог нанести дополнительный урон!");
                attacker.attack(target);
            }
        } else if (command == 2) {
            attacker.rest();
        } else if (command == 4) {
            shop();
        } else {
            System.out.println("Пропуск хода ");
        }

        System.out.printf("У %s сейчас %s единиц здоровья ", target.getName(), target.getHealth());
    }

    public void shop() {
        while(true)  {
            shop.displayItems();  // Отображаем предметы в магазине
            System.out.println("У вас " + hero.getGold() + " золота.");
            System.out.println("Ваш инвентарь:");

            int choice = scanner.nextInt();
            Item purchasedItem = shop.purchaseItem(choice, hero);  // Покупаем выбранный предмет

            if (purchasedItem != null) {
                if (purchasedItem instanceof HealthPotion) {
                    purchasedItem.use(hero); // Используем зелье здоровья

                }
            } else {
                break;  // Если вернулся null, значит игрок решил покинуть магазин
            }
        }
    }


    private void printResult() {
        if (hero.isAlive()) {

            System.out.println("Герой " + hero.getName() + " победил!");
            int droppedGold = monster.droppedGold();
            System.out.println("Получено " + droppedGold + " золота.");
        } else {
            System.out.println("Монстр " + monster.getName() + " победил!");
        }

        System.out.println("Игра окончена");
    }
}