package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.add(ITEM1, 5);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);

        DiscountBill dbill = new DiscountBill();
        dbill.setDiscount(10);
        dbill.add(ITEM1, 5);
        dbill.add(ITEM3, 3);
        dbill.add(ITEM6, 1);
        System.out.println(dbill);
        System.out.println("Скидка в процентах равна: " + dbill.getDiscount());
        System.out.println("Скидка в валюте равна: " + dbill.getAbsoluteDiscount());
    }
}
