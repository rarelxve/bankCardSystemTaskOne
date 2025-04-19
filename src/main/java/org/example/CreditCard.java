package org.example;

class CreditCard extends Card{
    private double percentRate;

    public CreditCard(String name, String currency, float balance, double percentRate) {
        super(name, currency, balance);
        this.percentRate = percentRate;
    }

    public double getLoanAmount(){
        return Math.abs(Math.min(balance, 0));
    }

    @Override
    public void debitBalance(float sumOfDebit) {
        if (sumOfDebit>0){
            balance -= sumOfDebit;
        }
        else {
            throw new IllegalArgumentException("Некорректная сумма");
        }
    }
}
