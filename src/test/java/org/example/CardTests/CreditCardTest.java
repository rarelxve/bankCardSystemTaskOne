package org.example.CardTests;

import org.example.Cards.CreditCard;
import org.example.Cards.DebetCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void constructorInitialisation() {
        CreditCard card = new CreditCard("Platinum", "RUB", 1500, 0.15);
        assertAll(
                () -> assertEquals("Platinum", card.getName()),
                () -> assertEquals("RUB", card.getCurrency()),
                () -> assertEquals(1500, card.getBalance())
        );
    }

    @Test
    void getEmptyLoanAmount() {
        CreditCard card = new CreditCard("Test", "RUB", 500, 0.12);
        assertEquals(0.0, card.getLoanAmount());
    }

    @Test
    void getLoanAmount() {
        CreditCard card = new CreditCard("Test", "RUB", -300, 0.1);
        assertEquals(300.0, card.getLoanAmount());
    }

    @Test
    void getLoanAmountZeroBalance() {
        CreditCard card = new CreditCard("Test", "RUB", 0, 0.05);
        assertEquals(0.0, card.getLoanAmount());
    }

    @Test
    void debitOperation() {
        CreditCard card = new CreditCard("Test", "RUB", 2000, 0.2);
        card.debitBalance(800);
        assertEquals(1200, card.getBalance());
    }

    @Test
    void debitOperationOverdraft() {
        CreditCard card = new CreditCard("Test", "RUB", 500, 0.18);
        card.debitBalance(700);
        assertEquals(-200, card.getBalance());
        assertEquals(200, card.getLoanAmount());
    }

    @Test
    void debitOperationNegativeValue() {
        CreditCard card = new CreditCard("Test", "RUB", 1000, 0.15);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> card.debitBalance(-200)
        );
        assertEquals("Некорректная сумма", exception.getMessage());
        assertEquals(1000, card.getBalance());
    }

    @Test
    void refillBalanceIncreasesBalance() {
        DebetCard debetCard = new DebetCard("Test", "RUB", 3000);
        debetCard.refillBalance(1000);
        assertEquals(4000, debetCard.getBalance());
    }
    @Test
    void debitOperationZeroValue() {
        CreditCard card = new CreditCard("Test", "RUB", 300, 0.1);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> card.debitBalance(0)
        );
        assertEquals("Некорректная сумма", exception.getMessage());
        assertEquals(300, card.getBalance());
    }
}