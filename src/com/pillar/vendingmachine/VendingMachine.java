package com.pillar.vendingmachine;

import com.pillar.vendingmachine.enumeratedType.Coin;

public class VendingMachine {

    private boolean coinSentToCoinReturn = false;
    private boolean coinValid = false;

    public void insertCoin(Coin insertedCoin){
        if(insertedCoin != Coin.penny){
            coinValid = true;
        }else{
            coinSentToCoinReturn = true;
        }
    }

    public boolean isCoinSentToCoinReturn(){
        return coinSentToCoinReturn;
    }

    public boolean isCoinValid(){
        return coinValid;
    }

    public void resetState(){
        coinSentToCoinReturn = false;
    }
}
