package org.example;

class Deposit extends BankProduct{
    private boolean isClosedAccount;

    public Deposit(String name, String currency, float balance) {
        super(name, currency, balance);
        this.isClosedAccount = false;
    }

    public void closeDeposit (){
        balance = Float.valueOf(0);
        isClosedAccount = true;
    }

    public void refillBalance(boolean isClosedAccount, float sumOfRefill){
        if (isClosedAccount) throw new IllegalArgumentException("Вклад закрыт, пополнение невозможно");
        if (sumOfRefill<=0) throw new IllegalArgumentException("Некорректная сумма");
        balance += sumOfRefill;
    }
}
