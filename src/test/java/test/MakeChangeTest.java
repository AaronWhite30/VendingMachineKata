package test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
        assertEquals(0.25f, vendingMachine.getCoinsSentToCoinReturn(),0f);
        vendingMachine.resetState();
        assertFalse(vendingMachine.changeSentToCoinReturn());
    }
}
