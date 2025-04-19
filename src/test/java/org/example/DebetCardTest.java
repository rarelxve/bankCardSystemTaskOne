package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebetCardTest {

    @Test
    void testDebetCardWithdrawPositiveAmount() {
        DebetCard card = new DebetCard("Debit", "RUB", 100);
        card.debitBalance(50);
        assertEquals(50, card.getBalance());
    }

    @Test
    void testDebetCardWithdrawNegativeAmount(){
        DebetCard card = new DebetCard("Debit", "RUB", 100);
        card.debitBalance(-50);
        //assertThrows(new IllegalArgumentException("Невозможно списать со счета не положительное значение") );
    }

}