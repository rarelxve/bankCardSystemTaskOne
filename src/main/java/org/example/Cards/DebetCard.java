package org.example.Cards;

public class DebetCard extends Card{
    public DebetCard(String name, String currency, float balance) {
        super(name, currency, balance);
    }

    public void debitBalance(float sumOfDebit){
        if (balance<sumOfDebit) throw new IllegalArgumentException("Сумма списания больше баланса дебетовой карты");
        if (sumOfDebit<=0) throw new IllegalArgumentException("Невозможно списать со счета не положительное значение");
        balance-=sumOfDebit;
    }
}
