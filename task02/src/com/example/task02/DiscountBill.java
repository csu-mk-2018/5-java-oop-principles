package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public DiscountBill() {
        discount = 0;
    }

    /**
     *
     * @param discount скидка в процентах
     */
    public DiscountBill(int discount) {
        setDiscount(discount);
    }

    @Override
    public long getPrice() {
        long sum = super.getPrice();
        sum -= (long)(((double)discount / 100) * sum);
        return sum;
    }

    public int getPercentDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
        long sum = super.getPrice();
        return (long)(((double)discount / 100) * sum);
    }

    public void setDiscount(int discount) {
        this.discount = Math.abs(discount);
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += " (скидка " + discount + "%)";
        return result;
    }

}
