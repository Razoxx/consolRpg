package com.lesson;

class MightySword extends Item {
    public MightySword() {
        super("Меч могущества", 10);
    }

    @Override
    public void use(Hero hero) {
        int damageIncrease = 3; // Здесь можно настроить, на сколько увеличивается урон от меча
        hero.increaseAttack(damageIncrease);
        System.out.println(hero.getName() + " использовал " + getName() + " и увеличил свой урон на " + damageIncrease + ".");
    }
}