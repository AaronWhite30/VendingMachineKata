package com.pillar.vendingmachine;

import com.pillar.vendingmachine.enumeratedType.Coin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {

    private String display;
    private boolean coinValid = false;
    private boolean selectColaProduct = false;
    private boolean colaProductAvailable = true;
    private List<Coin> accumulatedCoins = new ArrayList<Coin>();
    private List<Coin> bankedCoins = new ArrayList<Coin>();
    private float coinsSentToCoinReturn = 0f;

    public void insertCoin(Coin insertedCoin){
        if(insertedCoin != Coin.penny){
            coinValid = true;
            accumulatedCoins.add(insertedCoin);
        }else{
            coinsSentToCoinReturn = insertedCoin.getCoinValue();
        }
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
        coinValid = false;
        selectColaProduct = false;
        coinsSentToCoinReturn = 0f;
    }

    public String checkDisplay(){
        float coinsAccumulated = getCoinsAccumulated();
        if(selectColaProduct) {
            if(!colaProductAvailable){
                display = "SOLD OUT";
            }else {
                if (coinsAccumulated == 1.00f) {
                    display = "THANK YOU";
                    bankAccumulatedCoins();
                } else {
                    display = "PRICE $1.00";
                }
            }
        }else {
            if (accumulatedCoins.size() > 0) {
                display = String.format("$%.02f", coinsAccumulated);
            } else {
                if(bankedCoins.size() == 0){
                    display = "EXACT CHANGE ONLY";
                }else {
                    display = "INSERT COIN";
                }
            }
        }
        return display;
    }

    public void returnCoins(){
        accumulatedCoins.clear();
    }

    public void selectColaProduct(){
        selectColaProduct = true;
        float coinsAccumulated = getCoinsAccumulated();
        if (coinsAccumulated > 1.00f) {
            coinsSentToCoinReturn = coinsAccumulated - 1.00f;
        }
    }

    public boolean isSelectColaProduct(){
        return selectColaProduct;
    }

    private void bankAccumulatedCoins(){
        bankedCoins.addAll(Collections.unmodifiableList(accumulatedCoins));
        accumulatedCoins.clear();
    }

    public void setColaProductAvailable(boolean available){
        colaProductAvailable = available;
    }

    public void addToBankedCoins(Coin coin){
        bankedCoins.add(coin);
    }

    public void emptyBankedCoins(){
        bankedCoins.clear();
    }

    public float getCoinsSentToCoinReturn(){
        return coinsSentToCoinReturn;
    }
}
