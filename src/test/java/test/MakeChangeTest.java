package test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals(Coin.quarter.getCoinValue(), vendingMachine.getCoinsSentToCoinReturn(),0f);
        vendingMachine.resetState();
        assertEquals(0.00f, vendingMachine.getCoinsSentToCoinReturn(),0f);
    }
}
