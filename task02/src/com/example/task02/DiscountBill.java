package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount(){
        return getPrice()/(100-discount)*100 - getPrice();
    }

    @Override
    public long getPrice() {
        long price = 0;
        for (BillItem item: items) {
            price += item.item.getPrice() * item.amount;
        }
        return price-(price/discount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Счет к оплате\n");
        for(BillItem item : items) {
            sb.append(item.item.getName()).append('(').append(item.amount).append(')');
            sb.append('\n');
        }
        sb.append("Сумма к оплате с учетом скидки ").append(discount).append("% : ").append(getPrice());
        return sb.toString();
    }
}
