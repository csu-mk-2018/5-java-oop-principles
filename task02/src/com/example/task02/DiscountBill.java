package com.example.task02;

public class DiscountBill extends Bill {
    private int discountPercent;

    public DiscountBill() {
        discountPercent = 0;
    }

    public DiscountBill(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public long getPrice() {
        return super.getPrice() - (long)(super.getPrice() * (double)discountPercent / 100);
    }

    public long getProfit() {
        return super.getPrice() - this.getPrice();
    }
}
