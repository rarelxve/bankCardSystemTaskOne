package org.example.commonProducts;

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
}
