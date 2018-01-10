package com.pillar.vendingmachine;

import com.pillar.vendingmachine.enumeratedType.Coin;

public class VendingMachine {

    private boolean coinSentToCoinReturn = false;

    public void insertCoin(Coin insertedCoin){
        if(insertedCoin == Coin.penny){
            coinSentToCoinReturn = true;
        }
    }

    public boolean isCoinSentToCoinReturn(){
        return coinSentToCoinReturn;
    }

    public void resetState(){
        coinSentToCoinReturn = false;
    }
}
