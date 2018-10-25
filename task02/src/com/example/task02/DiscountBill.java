package com.example.task02;

public class DiscountBill extends Bill {

    private int discount;

    public DiscountBill(){
        discount=0;
    }

    public int getDiscount() {
        return discount;
    }

    public long getProfit() {
        return super.getPrice() - this.getPrice();
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discount));
        }
        else {
            this.discount = discount;
        }
    }

    @Override
    public long getPrice() {
        long discountPrice = super.getPrice();
        discountPrice *= (100 - discount);
        return discountPrice / 100;
    }

    @Override
    public String toString() {
        if (discount == 0) {
            return super.toString();
        }
        else {
            return super.toString() + "сo скидкой" + discount + "%";
        }
    }
}
