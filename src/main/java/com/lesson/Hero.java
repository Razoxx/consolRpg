package com.lesson;

import java.util.Random;

class Hero {
    private String name;
    private int health;
    private int attack;

    public Hero(String name, int health, int attack) {
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

    public void performAttack(Monster monster, Random random) {
        System.out.println("Герой " + name + " атакует " + monster.getName() + " и наносит " + attack + " урона");
        monster.receiveDamage(attack, random);
    }

    public void defend() {
        System.out.println("Герой " + name + " использовал защиту и восполнил HP");
        health++;
    }

    public void receiveDamage(int attack) {
    }
}
