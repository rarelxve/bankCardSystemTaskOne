package org.example;

class ForeignCurrencyCard extends Card{
    public ForeignCurrencyCard(String name, String currency, float balance) {
        super(name, currency, balance);
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
