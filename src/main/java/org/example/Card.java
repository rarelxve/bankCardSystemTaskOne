package org.example;

abstract class Card extends BankProduct{
    public Card(String name, String currency, float balance) {
        super(name, currency, balance);
    }

    protected void debitBalance (float sumOfDebit){
        if (sumOfDebit>0){
            balance -= sumOfDebit;
        }
        else {
            throw new IllegalArgumentException("Некорректная сумма");
        }
    }
}
