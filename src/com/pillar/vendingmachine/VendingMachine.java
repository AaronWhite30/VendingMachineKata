package com.pillar.vendingmachine;

import com.pillar.vendingmachine.enumeratedType.Coin;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private String display;
    private boolean coinSentToCoinReturn = false;
    private boolean coinValid = false;
    private boolean coinsSentToCoinReturn = false;
    private List<Coin> accumulatedCoins = new ArrayList<>();

    public void insertCoin(Coin insertedCoin){
        if(insertedCoin != Coin.penny){
            coinValid = true;
            accumulatedCoins.add(insertedCoin);
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

    public float getCoinsAccumulated(){
        float total = 0;
        for (Coin coin : accumulatedCoins) {
            total = total + coin.getCoinValue();
        }
        return total;
    }

    public void resetState(){
        coinSentToCoinReturn = false;
        coinValid = false;
        coinsSentToCoinReturn = false;
    }

    public String checkDisplay(){
        if(accumulatedCoins.size() > 0){
            float displayTotal = getCoinsAccumulated();
            display = String.format("%.02f", displayTotal);
        }else {
            display = "INSERT COIN";
        }
        return display;
    }

    public void returnCoins(){
        coinsSentToCoinReturn = true;
        accumulatedCoins.clear();
    }

    public boolean isCoinsSentToCoinReturn(){
        return coinsSentToCoinReturn;
    }
}
