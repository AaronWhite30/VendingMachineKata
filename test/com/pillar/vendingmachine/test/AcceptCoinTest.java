package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.enumeratedType.Coin;
import com.pillar.vendingmachine.VendingMachine;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class AcceptCoinTest {

    @Test
    public void testAcceptCoinIsInvalid(){

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.penny);
        assertTrue(vendingMachine.isCoinSentToCoinReturn());
        vendingMachine.resetState();
        assertFalse(vendingMachine.isCoinSentToCoinReturn());
    }
}
