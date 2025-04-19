package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DebetCardTest {

    @Test
    void debetCardReduceBalance() {
        DebetCard card = new DebetCard("Test", "RUB", 1000);
        card.debitBalance(500);
        assertEquals(500, card.getBalance());
    }

    @Test
    void debetCardReduceFullBalance() {
        DebetCard card = new DebetCard("Test", "RUB", 1000);
        card.debitBalance(1000);
        assertEquals(0, card.getBalance());
    }

    @Test
    void debetCardOverdraftException() {
        DebetCard card = new DebetCard("Test", "RUB", 200);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> card.debitBalance(201));
        assertEquals("Сумма списания больше баланса дебетовой карты", exception.getMessage());
        assertEquals(200, card.getBalance());
    }

    @Test
    void debetCardReduceZeroAmount() {
        DebetCard card = new DebetCard("Test", "RUB", 200);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> card.debitBalance(0));
        assertEquals("Невозможно списать со счета не положительное значение", exception.getMessage());
        assertEquals(200, card.getBalance());
    }

    @Test
    void debetCardReduceNegativeAmount() {
        DebetCard card = new DebetCard("Test", "RUB", 200);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> card.debitBalance(-200));
        assertEquals("Невозможно списать со счета не положительное значение", exception.getMessage());
        assertEquals(200, card.getBalance());
    }

    @Test
    void debitBalance_ZeroBalance_ThrowsException() {
        DebetCard card = new DebetCard("Test", "RUB", 0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> card.debitBalance(100));
        assertEquals("Сумма списания больше баланса дебетовой карты", exception.getMessage());
        assertEquals(0.0, card.getBalance());
    }
}