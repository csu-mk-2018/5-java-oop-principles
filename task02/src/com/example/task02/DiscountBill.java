package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;


    public DiscountBill() {
        this.discount = 0;
    }

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public double getAbsDiscountValue() {
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        return super.getPrice() - super.getPrice() * discount / 100;
    }
}
