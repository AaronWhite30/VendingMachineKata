package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    public void testNotEnoughCoinsWhenSelectColaProduct(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("PRICE $1.00", vendingMachine.checkDisplay());
        vendingMachine.resetState();
        assertFalse(vendingMachine.isSelectColaProduct());
        assertEquals("$0.25", vendingMachine.checkDisplay());
    }

    @Test
    public void testExactCoinsPresentWhenSelectColaProduct(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("THANK YOU", vendingMachine.checkDisplay());
        vendingMachine.resetState();
        assertEquals("INSERT COIN", vendingMachine.checkDisplay());
    }
    @Test
    public void testNoCoinsPresentWhenSelectColaSoldOutProduct(){
        vendingMachine.setColaProductAvailable(false);
        vendingMachine.selectColaProduct();
        assertEquals("SOLD OUT", vendingMachine.checkDisplay());
        vendingMachine.resetState();
        assertEquals("INSERT COIN", vendingMachine.checkDisplay());
    }

    @Test
    public void testNotEnoughCoinsPresentWhenSelectColaSoldOutProduct(){
        vendingMachine.setColaProductAvailable(false);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("SOLD OUT", vendingMachine.checkDisplay());
        vendingMachine.resetState();
        assertEquals("$0.25", vendingMachine.checkDisplay());
    }

}
