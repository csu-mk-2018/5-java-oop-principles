package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
            return getPrice() - super.getPrice();
    }

    @Override
    public long getPrice() {
            return super.getPrice()*(100 - discount)/100;
    }
}
