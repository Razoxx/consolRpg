package com.lesson;

class HealthPotion extends Item {
    public HealthPotion() {
        super("Зелье здоровья", 5);
    }

    @Override
    public void use(Hero hero) {
        int healingAmount = 5;
        hero.heal(healingAmount);
        System.out.println(hero.getName() + " использовал " + getName() + " и восстановил " + healingAmount + " здоровья.");
    }
}