package org.example.depositTest;

import org.example.deposits.Deposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @Test
    void constructorInitialisation() {
        Deposit deposit = new Deposit("Savings", "RUB", 5000);
        assertAll(
                () -> assertEquals("Savings", deposit.getName()),
                () -> assertEquals("RUB", deposit.getCurrency()),
                () -> assertEquals(5000, deposit.getBalance()),
                () -> assertFalse(deposit.isClosedAccount())
        );
    }

    @Test
    void closeDeposit() {
        Deposit deposit = new Deposit("Term", "EUR", 3000);
        deposit.closeDeposit();
        assertAll(
                () -> assertEquals(0, deposit.getBalance()),
                () -> assertTrue(deposit.isClosedAccount())
        );
    }

    @Test
    void refillBalanceClosedAccountException() {
        Deposit deposit = new Deposit("Test", "RUB", 1000);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> deposit.refillBalance(true, 500)
        );
        assertEquals("Вклад закрыт, пополнение невозможно", exception.getMessage());
        assertEquals(1000, deposit.getBalance());
    }

    @Test
    void refillBalanceNegativeAmountException() {
        Deposit deposit = new Deposit("Test", "RUB", 2000);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> deposit.refillBalance(false, -100)
        );
        assertEquals("Некорректная сумма", exception.getMessage());
        assertEquals(2000, deposit.getBalance());
    }

    @Test
    void refillBalanceZeroAmountException() {
        Deposit deposit = new Deposit("Test", "RUB", 1500);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> deposit.refillBalance(false, 0)
        );
        assertEquals("Некорректная сумма", exception.getMessage());
        assertEquals(1500, deposit.getBalance());
    }

    @Test
    void refillBalanceIncreasesBalance() {
        Deposit deposit = new Deposit("Test", "RUB", 3000);
        deposit.refillBalance(false, 1000);
        assertEquals(4000, deposit.getBalance());
    }
}