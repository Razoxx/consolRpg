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
}
