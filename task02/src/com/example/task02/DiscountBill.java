package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;


    public DiscountBill() {
        this.discount = 0;
    }

    public DiscountBill(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discount));
        }
        this.discount = discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discount));
        }
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
        long currentPrice = super.getPrice();
        return (long)currentPrice - currentPrice * discount / 100;
    }
}
