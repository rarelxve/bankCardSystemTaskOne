package org.example;

public class CreditCard extends Card{
    private double percentRate;

    public CreditCard(String name, String currency, float balance, double percentRate) {
        super(name, currency, balance);
        this.percentRate = percentRate;
    }

    public double getLoanAmount(){
        return Math.max(balance, 0);
    }
}
