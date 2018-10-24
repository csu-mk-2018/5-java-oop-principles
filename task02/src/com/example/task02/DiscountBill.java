package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public DiscountBill() {
        discount = 0;
    }

    /**
     *
     * @param discount скидка в процентах
     * @throws IllegalArgumentException Некорректное значение скидки
     */
    public DiscountBill(int discount) throws IllegalArgumentException {
        setDiscount(discount);
    }

    @Override
    public long getPrice() {
        long sum = super.getPrice();
        sum -= (long) (((double) discount / 100) * sum);
        return sum;
    }

    public int getPercentDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
        long sum = super.getPrice();
        return (long) (((double) discount / 100) * sum);
    }

    /**
     *
     * @param discount скидка в процентах
     * @throws IllegalArgumentException Некорректное значение скидки
     */
    public void setDiscount(int discount) throws IllegalArgumentException {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(String.format("Некорректное значение скидки %d", discount));
        } else {
            this.discount = discount;
        }
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += " (скидка " + discount + "%)";
        return result;
    }

}
