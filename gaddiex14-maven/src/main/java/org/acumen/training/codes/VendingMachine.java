package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VendingMachine {

    private static final Logger logger = LogManager.getLogger("VendingMachine");
   
    @SuppressWarnings("unused")
	private int totValue;
    private int currValue;
    private boolean enabled;
    private static final int COST = 75;

    public VendingMachine() {
        logger.info("VendingMachine instance created");
        totValue = 0;
        currValue = 0;
        enabled = false;
    }

    public void insert(Coin coin) {
        logger.info("Starting execution of insert()");
        int value = coin.getValue();
        if (value == 0) {
            logger.error("Illegal value coin inserted: " + coin);
        } else {
            currValue += value;
            logger.info("Current value = " + currValue);
            if (currValue >= COST) {
                enabled = true;
                System.out.println( " (sufficient credit)" );
                logger.info("Sufficient credit (current value: " + currValue + ")");
            } else {
            	System.out.println( "" );
                logger.info("Insufficient credit (current value: " + currValue + ")");
            }
        }
        logger.info("Ending execution of insert()");
    }

    public void returnCoins() {
        logger.info("Starting execution of returnCoins()");
        if (currValue == 0) {
            logger.error("No coins to return");
        } else {
            logger.info("Take your coins (current value reset)");
            currValue = 0;
            enabled = false;
        }
        logger.info("Ending execution of returnCoins()");
    }

    public void vend() throws Exception {
        logger.info("Starting execution of vend()");
        try {
            if (enabled) {
                logger.info("Get your drink");
                totValue += COST;
                currValue -= COST;
                if (currValue == 0) {
                    enabled = false;
                }
                logger.info("Current value after vending: " + currValue);
            } else {
                logger.error("Not enough credit: add " + (COST - currValue));
            }
            if (currValue < 0) {
                logger.error("Error: negative credit!");
                throw new Exception("Error: negative credit!");
            }
        } catch (Exception e) {
            logger.error("Exception caught: " + e.getMessage(), e);
            throw e;
        }
        logger.info("Ending execution of vend()");
    }
}
