package com.nphase.entity;

import java.math.BigDecimal;

public class DiscountConfiguration {

    private final int amount;

    private final BigDecimal discountValue;

    public DiscountConfiguration(int amount, BigDecimal discountValue) {
        this.amount = amount;
        this.discountValue = discountValue;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }


}
