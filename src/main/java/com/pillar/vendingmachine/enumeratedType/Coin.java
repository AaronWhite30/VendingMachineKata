package com.pillar.vendingmachine.enumeratedType;

public enum Coin {
    penny(0.01f),nickel(0.05f),dime(0.10f),quarter(0.25f);
    Coin(float coinValue){
        this.coinValue = coinValue;
    }
    float coinValue;
    public float getCoinValue(){
        return coinValue;
    }
}
