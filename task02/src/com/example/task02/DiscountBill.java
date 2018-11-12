package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discount));
        } else {
            this.discount = discount;
        }
    }

    public int getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
        return getPrice() - super.getPrice();
    }

    @Override
    public long getPrice() {
        return super.getPrice() * (100 - discount) / 100;
    }
}
