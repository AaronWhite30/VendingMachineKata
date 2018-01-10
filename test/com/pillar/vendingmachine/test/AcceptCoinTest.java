package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.enumeratedType.Coin;
import com.pillar.vendingmachine.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AcceptCoinTest {

    private VendingMachine vendingMachine;

    @Before
    public void setup(){
        this.vendingMachine = new VendingMachine();
    }

    @Test
    public void testAcceptCoinIsInvalid(){
        vendingMachine.insertCoin(Coin.penny);
        assertTrue(vendingMachine.isCoinSentToCoinReturn());
        vendingMachine.resetState();
        assertFalse(vendingMachine.isCoinSentToCoinReturn());
    }

    @Test
    public void testAcceptCoinIsValid(){
        vendingMachine.insertCoin(Coin.nickel);
        assertTrue(vendingMachine.isCoinValid());
        vendingMachine.resetState();
        assertFalse(vendingMachine.isCoinValid());
    }

    @Test
    public void testValidCoinAccumulates(){
        vendingMachine.insertCoin(Coin.nickel);
        assertTrue(vendingMachine.getCoinsAccumulated() == Coin.nickel.getCoinValue());
    }
}
