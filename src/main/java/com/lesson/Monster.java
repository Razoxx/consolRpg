package com.lesson;

import java.util.Random;

class Monster extends Character {
     int minGold;
     int maxGold;

    public Monster(String name, int health, int attack, int minGold, int maxGold) {
        super(name, health, attack);
        this.minGold = minGold;
        this.maxGold = maxGold;
    }

    public int droppedGold() {
        int droppedGold = new Random().nextInt(maxGold - minGold + 1) + minGold;
        System.out.println("Монстр " + name + " умирает и оставляет " + droppedGold + " золота.");
        return droppedGold;
    }


}



