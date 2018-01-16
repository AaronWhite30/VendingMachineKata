package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MakeChangeTest {

    @Test
    public void testMakeChangeOnColaWhenCoinsInsertedMoreThanColaPrice(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertTrue(vendingMachine.changeSentToCoinReturn());
        vendingMachine.resetState();
        assertFalse(vendingMachine.changeSentToCoinReturn());
    }
}
