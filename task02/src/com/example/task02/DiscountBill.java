package com.example.task02;

public class DiscountBill extends Bill {
    private int discountPercent;

    public DiscountBill() {
        discountPercent = 0;
    }

    public DiscountBill(int discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discountPercent));
        }
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discountPercent));
        }
        this.discountPercent = discountPercent;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return price - (long)(price * (double)discountPercent / 100);
    }

    public long getProfit() {
        return super.getPrice() - this.getPrice();
    }
}
