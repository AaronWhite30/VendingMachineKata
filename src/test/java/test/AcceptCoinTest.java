package test;

import com.pillar.vendingmachine.enumeratedType.Coin;
import com.pillar.vendingmachine.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
        assertEquals(Coin.penny.getCoinValue(), vendingMachine.getCoinsSentToCoinReturn(),0f);
        vendingMachine.resetState();
        assertEquals(0.00f, vendingMachine.getCoinsSentToCoinReturn(),0f);
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
