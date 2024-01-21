package com.lesson;


import java.util.ArrayList;



class Hero extends Character {
    private int gold;
    private ArrayList<Item> inventory;

    public Hero(String name, int health, int attack) {
        super(name, health, attack);
        this.gold = 50;
        this.inventory = new ArrayList<>();
    }
    public int getGold() {
        return gold;
    }
    public void earnGold(int amount) {
        gold += amount;
        System.out.println(name + " получил " + amount + " золота. Теперь у него " + gold + " золота.");
    }



    public void heal(int amount) {
        health += amount;
        System.out.println(getName() + " восстановил " + amount + " здоровья. Теперь у него " + health + " здоровья.");
    }

    public String getName() {
        return name;
    }

    public int getInventory() {
        return health;
    }

    public void increaseAttack(int damageIncrease) {
    }

    public void buyItem(Item item) {
        if (gold >= item.getCost()) {
            gold -= item.getCost();
            inventory.add(item);
            System.out.println(name + " купил " + item.getName() + " за " + item.getCost() + " золота.");
        } else {
            System.out.println(name + " не может купить " + item.getName() + ". Недостаточно золота.");
        }
    }
}