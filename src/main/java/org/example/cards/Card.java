package org.example.cards;

import org.example.commonProducts.BankProduct;

public abstract class Card extends BankProduct {
    public Card(String name, String currency, float balance) {
        super(name, currency, balance);
    }

    public void refillBalance(float sumOfRefill){
        if (sumOfRefill>0){
            balance += sumOfRefill;
        }
        else {
            throw new IllegalArgumentException("Некорректная сумма");
        }
    }
    public abstract void debitBalance (float sumOfDebit);
}
