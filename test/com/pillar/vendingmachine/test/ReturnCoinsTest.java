package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

public class ReturnCoinsTest {

    @Test
    public void testReturnCoinsWhenReturnCoinsRequested(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.returnCoins();
        Assert.assertTrue(vendingMachine.isCoinsSentToCoinReturn());
    }
}
