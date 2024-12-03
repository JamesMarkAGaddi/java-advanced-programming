package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Coin {
    public static final int PENNY = 1;
    public static final int NICKEL = 5;
    public static final int DIME = 10;
    public static final int QUARTER = 25;
    public static final int HALFDOLLAR = 50;
    public static final int SILVERDOLLAR = 100;
    public static final int INVALID = 0;

    private static final Logger logger = LogManager.getLogger("VendingMachine");

    private int value;

    public Coin(String coin) {
        logger.info("Coin instance created with input: " + coin);
        String toUpperCoin = coin.toUpperCase();
        if (toUpperCoin.equals("PENNY")) value = PENNY;
        else if (toUpperCoin.equals("NICKEL")) value = NICKEL;
        else if (toUpperCoin.equals("DIME")) value = DIME;
        else if (toUpperCoin.equals("QUARTER")) value = QUARTER;
        else if (toUpperCoin.equals("HALFDOLLAR")) value = HALFDOLLAR;
        else if (toUpperCoin.equals("SILVERDOLLAR")) value = SILVERDOLLAR;
        else value = INVALID;

        logger.info("Coin type: " + toUpperCoin + " with value: " + value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
