package com.lesson;

import java.util.ArrayList;
class Shop {
    private ArrayList<Item> items;

    public Shop() {
        items = new ArrayList<>();
        items.add(new HealthPotion());
        items.add(new MightySword());
    }

    public boolean displayItems() {
        System.out.println("Магазин. Выберите предмет для покупки:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " (" + items.get(i).getCost() + " золота)");
        }
        System.out.println((items.size() + 1) + ". Покинуть магазин");
        return false;
    }

    public Item purchaseItem(int choice, Hero hero) {
        if (choice >= 1 && choice <= items.size()) {
            Item selectedItem = items.get(choice - 1);
            if (hero.getGold() >= selectedItem.getCost()) {
                hero.buyItem(selectedItem);
                return selectedItem;
            } else {
                System.out.println("У вас недостаточно золота для покупки этого предмета.");
            }
        } else if (choice == items.size() + 1) {
            System.out.println("Вы покинули магазин.");
        } else {
            System.out.println("Неверный выбор.");
        }
        return null;
    }
}
