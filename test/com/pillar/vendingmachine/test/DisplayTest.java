package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DisplayTest {
    private VendingMachine vendingMachine;

    @Before
    public void setup(){
        this.vendingMachine = new VendingMachine();
    }

    @Test
    public void testDisplayWhenNoCoinsPresent(){
        assertTrue(0.00f == vendingMachine.getCoinsAccumulated());
        assertEquals(vendingMachine.checkDisplay(), "INSERT COIN");
    }

    @Test
    public void testDisplayUpdatesWhenValidCoinIsInserted(){
        vendingMachine.insertCoin(Coin.quarter);
        assertEquals(vendingMachine.checkDisplay(), "0.25");
        vendingMachine.insertCoin(Coin.nickel);
        assertEquals(vendingMachine.checkDisplay(), "0.30");
    }
}
