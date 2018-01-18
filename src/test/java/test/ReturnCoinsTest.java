package test;

import com.pillar.vendingmachine.VendingMachine;
import com.pillar.vendingmachine.enumeratedType.Coin;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ReturnCoinsTest {

    @Test
    public void testReturnCoinsRequestedAccumulatedCoinsIsZero(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.returnCoins();
        assertEquals(Coin.quarter.getCoinValue(), vendingMachine.getCoinsSentToCoinReturn(),0f);
        vendingMachine.resetState();
        assertEquals(0.00f, vendingMachine.getCoinsSentToCoinReturn(),0f);
    }
}
