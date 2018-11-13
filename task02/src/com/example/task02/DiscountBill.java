package com.example.task02;

public class DiscountBill
        extends Bill {

    private int Discount;

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        if (Discount < 0 || Discount > 100) {
            throw new AssertionError("Таких скидок не бывает:(.");
        } else {
            this.Discount = Discount;
        }
    }

    @Override
    public long getPrice() {
        long DiscountPrice = super.getPrice();
        DiscountPrice *= (100 - Discount);
        return DiscountPrice / 100;
    }

    public long advantage() {
        return super.getPrice() - this.getPrice();
    }

    @Override
    public String toString() {
        if (Discount < 0) {
            return super.toString();
        }
        else {
            return super.toString() + " сo скидкой " + Discount + " %";
        }
    }
}
