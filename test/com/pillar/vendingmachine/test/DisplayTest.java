package com.pillar.vendingmachine.test;

import com.pillar.vendingmachine.VendingMachine;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DisplayTest {

    @Test
    public void testDisplayWhenNoCoinsPresent(){
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(0.00f == vendingMachine.getCoinsAccumulated());
        assertEquals(vendingMachine.checkDisplay(), "INSERT COIN");
    }
}
