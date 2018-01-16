package com.pillar.vendingmachine;

import com.pillar.vendingmachine.enumeratedType.Coin;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private String display;
    private boolean coinSentToCoinReturn = false;
    private boolean coinValid = false;
    private boolean selectColaProduct = false;
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
        selectColaProduct = false;
    }

    public String checkDisplay(){
        float coinsAccumulated = getCoinsAccumulated();
        if(selectColaProduct) {
            if(coinsAccumulated != 1.00f){
                display = "PRICE $1.00";
            }
        }else {
            if (accumulatedCoins.size() > 0) {
                display = String.format("$%.02f", coinsAccumulated);
            } else {
                display = "INSERT COIN";
            }
        }
        return display;
    }

    public void returnCoins(){
        accumulatedCoins.clear();
    }

    public void selectColaProduct(){
        selectColaProduct = true;
    }

    public boolean isSelectColaProduct(){
        return selectColaProduct;
    }
}
