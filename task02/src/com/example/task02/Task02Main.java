package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 360);
    private static final Item ITEM2 = new Item("Товар 2", 410);
    private static final Item ITEM3 = new Item("Товар 3", 500);
    private static final Item ITEM4 = new Item("Товар 4", 845);

    public static void main(String[] args) {
        DiscountBill dBill = new DiscountBill();
        dBill.add(ITEM1, 10);
        dBill.add(ITEM3, 4);
        dBill.setDiscount(0);
        System.out.println(dBill);
        System.out.println(dBill.advantage());


    }
}
