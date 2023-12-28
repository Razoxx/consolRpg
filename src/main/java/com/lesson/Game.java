package com.lesson;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class Game {
     Hero hero;
     Monster monster;
     Scanner scanner;
     Random random;
     int dropGold;
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
                System.out.printf("Герой %S  вошел в лес и увидел %S. Игра началась", hero.name, monster.name );

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
        }
        else if(command == 4){
            shop.displayItems();

        }
        else {
            System.out.println("Пропуск хода ");
        }


        System.out.printf("У %S сейчас %S единиц здоровья ", target.name,  target.health );
    }
    void shop() {
        while (true) {
            shop.displayItems();  // Отображаем предметы в магазине
            System.out.println("У вас " + hero.getGold() + " золота.");
            System.out.println("Ваш инвентарь:");
            ArrayList<Item> inventory = hero.getInventory();
            if (inventory.isEmpty()) {
                System.out.println("Инвентарь пуст.");
            } else {
                for (Item item : inventory) {
                    System.out.println("- " + item.getName());
                }
            }

            int choice = scanner.nextInt();
            Item purchasedItem = shop.purchaseItem(choice, hero);  // Покупаем выбранный предмет

            if (purchasedItem != null) {
                if (purchasedItem instanceof HealthPotion) {
                    ((HealthPotion) purchasedItem).use(hero); // Используем зелье здоровья
                    inventory.remove(purchasedItem); // Удаляем использованное зелье из инвентаря
                }
            } else {
                break;  // Если вернулся null, значит игрок решил покинуть магазин
            }
        }
    }
    private void printResult() {
        if (hero.isAlive()) {
            dropGold = monster.droppedGold();
            System.out.println("Герой " + hero.name + " победил!");
        } else {
            System.out.println("Монстр " + monster.name + " победил!");
        }

        System.out.println("Игра окончена");
        shop();
    }
}