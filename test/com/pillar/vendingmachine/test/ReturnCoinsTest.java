package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ReturnCoinsTest {

    @Test
    public void testReturnCoinsWhenReturnCoinsRequested(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.returnCoins();
        assertTrue(vendingMachine.isCoinsSentToCoinReturn());
        vendingMachine.resetState();
        assertFalse(vendingMachine.isCoinsSentToCoinReturn());
    }

    @Test
    public void testReturnCoinsRequestedAccumulatedCoinsIsZero(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.returnCoins();
        assertTrue(vendingMachine.getCoinsAccumulated() == 0.00f);
    }
}
