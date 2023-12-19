package com.lesson;

import java.util.Random;
import java.util.Scanner;

class Monster {
    private String name;
    private int health;
    private int attack;

    public Monster(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void performAttack(Hero hero) {
        System.out.println("Монстр атакует " + hero.getName() + " и наносит " + attack + " урона");
        hero.receiveDamage(attack);
    }

    public void rest() {
        System.out.println("Монстр отдыхает");
        health += 2;
    }

    public void receiveDamage(int damage, Random random) {
        health -= damage;
        if (health <= 0) {
            System.out.println("Монстр " + name + " проиграл");
        }
    }

    public static class RpgGame {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("Введите имя героя ");

            String heroName = scanner.next();
            int heroHP = 15;
            int heroAttack = 5;

            String monsterName = "Орка";
            int monsterHP = 15;
            int monsterAttack = 3;

            System.out.println("Старт игры");
            System.out.println("Герой " + heroName + " вошел в лес и увидел " + monsterName + ". " +
                    "Игра началалсь");
            while (true) {
                System.out.println("Режим битвы");
                System.out.println("Выбери действие: 1.Атака 2.Защита 3.Уклонение                                                                                                                               ");
                int command = scanner.nextInt();
                if (command == 1) {
                    System.out.println("Герой  атакует " + monsterName + " наносит " + monsterHP + " урона");
                    monsterHP -= heroAttack;
                    if(random.nextInt(100)< 10){
                        System.out.println("Герой смог нанести дополнительный урон " +heroAttack+ " ед. урона");
                        monsterHP-=heroAttack;
                    }
                    System.out.println("У монстра " + monsterName + " осталось " + monsterHP + "здоровья");
                } else if (command == 2) {
                    System.out.println("Герой " + heroName + " использовал защиту и восполнил HP ");
                    heroHP++;
                } else {
                    System.out.println("Пропуск хода ");
                }

                System.out.println("У героя " + heroName + " сейчас " + heroHP + " единиц здоровья ");

                System.out.println("Ход монстра ");
                int monsterCommand = random.nextInt(1);
                if(monsterCommand == 1) {
                    System.out.println("Монстр  Атакует  " + heroName + " наносит " + monsterAttack + " Урона");
                    heroHP -= monsterAttack;
                    if (heroHP <= 0) {
                        System.out.println("Монстр победил");
                        break;
                    }
                }else if (monsterCommand == 1){
                    System.out.println("Монстр  отдыхает");
                    monsterHP+=2;

                }if(monsterHP<=0){
                    System.out.println("Монстр проиграл");
                }
                System.out.println("Герой " + heroName + " имеет " + heroHP + " единиц здоровья ");

            }

             System.out.println("Игра окончена");
        }
    }
}
