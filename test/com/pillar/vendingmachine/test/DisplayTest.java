package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import junit.framework.TestCase;
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
        assertEquals("INSERT COIN", vendingMachine.checkDisplay());
    }

    @Test
    public void testDisplayUpdatesWhenValidCoinIsInserted(){
        vendingMachine.insertCoin(Coin.quarter);
        assertEquals("$0.25", vendingMachine.checkDisplay());
        vendingMachine.insertCoin(Coin.nickel);
        assertEquals("$0.30", vendingMachine.checkDisplay());
    }

    @Test
    public void testDisplayUpdatesWhenReturnCoinsRequested(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.returnCoins();
        assertEquals("INSERT COIN", vendingMachine.checkDisplay());
    }

    @Test
    public void testSelectNotEnoughCoinsWhenSelectColaProduct(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("PRICE $1.00", vendingMachine.checkDisplay());
    }
}
