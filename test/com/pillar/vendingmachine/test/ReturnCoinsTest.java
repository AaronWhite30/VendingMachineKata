package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
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
}
