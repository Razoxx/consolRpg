package com.lesson;

class Character {
  String name;
  int health;
  int attack;


  public Character(String name, int health, int attack){
      this.name =name;
      this.health = health;
      this.attack = attack;
  }
    public boolean isAlive() {

        return false;
    }
    public void receiveDamage(int damage) {

    }
    public void attack(Character target) {

    }
    public void rest() {

    }
}
