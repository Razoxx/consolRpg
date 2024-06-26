package com.lesson;

class Character {
    String name;
    int health;
    int attack;

    public Character(String name, int health, int attack) {
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

    public void attack(Character target) {
        System.out.println(name + " атакует " + target.name + " и наносит " + attack + " урона");
        target.receiveDamage(attack);
    }

    public void receiveDamage(int damage) {
        health -= damage;
        System.out.println(name + " получает " + damage + " урона. У него осталось " + health + " здоровья.");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void rest() {
        System.out.println(name + " отдыхает и восполняет здоровье.");
        health++;
    }

}