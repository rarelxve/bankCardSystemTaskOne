package org.example;

public abstract class BankProduct {
    protected String name;
    protected String currency;
    protected Float balance;

    public BankProduct(String name, String currency, float balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    protected void refillBalance(float sumOfRefill){
        if (sumOfRefill>0){
            balance += sumOfRefill;
        }
        else {
            throw new IllegalArgumentException("Некорректная сумма");
        }
    }
}
