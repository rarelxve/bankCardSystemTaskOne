package org.example.Deposits;

import org.example.CommonProducts.BankProduct;

public class Deposit extends BankProduct {
    private boolean isClosedAccount;

    public Deposit(String name, String currency, float balance) {
        super(name, currency, balance);
        this.isClosedAccount = false;
    }

    public void closeDeposit (){
        balance = 0.00f;
        isClosedAccount = true;
    }

    public boolean isClosedAccount() {
        return isClosedAccount;
    }

    public void refillBalance(boolean isClosedAccount, float sumOfRefill){
        if (isClosedAccount) throw new IllegalArgumentException("Вклад закрыт, пополнение невозможно");
        if (sumOfRefill<=0) throw new IllegalArgumentException("Некорректная сумма");
        balance += sumOfRefill;
    }
}
