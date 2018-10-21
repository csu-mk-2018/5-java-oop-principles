package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(1000);
        TimeUnit unit2 = new Hours(3);
        TimeUnit unit3 = new Milliseconds(29999);
        TimeUnit unit4 = new Minutes(30);
        printTimeUnit(unit1);
        printTimeUnit(unit2);
        printTimeUnit(unit3);
        printTimeUnit(unit4);
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
        System.out.println(String.format("hours:      %d", unit.toHours()));
    }
}
